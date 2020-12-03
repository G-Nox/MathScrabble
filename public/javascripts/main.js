const point = {
    "=": 1,
    "+": 1,
    "-": 1,
    "*": 2,
    "/": 3,
    "1": 1,
    "2": 1,
    "3": 2,
    "4": 2,
    "5": 3,
    "6": 2,
    "7": 4,
    "8": 2,
    "9": 2,
    "0": 1
}

function recolor(element, arr) {
    arr.removeClass("activeDiv")
    element.classList.add("activeDiv")
}

function setCard() {
    const isActive = (element) => element.classList.contains("activeDiv")

    let rowarr = $(".myRow")
    let activeCard = $(".inHand").filter(isActive)

    if (activeCard) {
        for (var i = 0; i < rowarr.length; i++) {
            let row = rowarr[i]
            let cells = row.getElementsByClassName("myCell")
            let activeCell = cells.findIndex(isActive)
            if (activeCell >= 0) {
                console.log([activeCell,i])
                let url = "/scrabble/set/" + (activeCell - 1) + "/" + (i - 1) + "/" + activeCard
                document.location.replace(url)
            }
        }
    } else {
        alert("No card was selected")
    }
}

function updateGrid(result){
    let cells = $(".myCell").not(".myLabel")
    let index = 0
    let newcells = result.gameField.grid.cells
    let size = newcells.length

    for(var i = 0;i < size;i++){
        for(var j = 0;j < size;j++){
            if(newcells[j][i].value !== "") {
                let html = "<div class=\"myCharacter\">"+newcells[j][i].value+"</div>"
                    +"<div class=\"myPoint\">"+ point[newcells[j][i].value]+"</div>"
                cells[index].classList.add("myCard")
                cells[index].innerHTML = html
            }
            index ++
        }
    }
}

function newGrid(result) {
    let grid = result.gameField.grid.cells
    let gridsize = result.gameField.grid.cells.length
    let html = "<div class=\"myRow\"> <div class=\"myCell myLabel\"> </div>"
    for(let i = 1;i < gridsize + 1;i++) {
        html += "<div class=\"myCell myLabel\">"+i+"</div>"
    }
    html += "</div>"
    for(let col = 0;col < gridsize;col++) {
        html+="<div class=\"myRow\">" +
            "<div class=\"myCell myLabel\">"+(col+1)+"</div>"
        for(let row =0;row < gridsize; row++) {
            if(grid[row][col].value !== "") {
                html+="<div class=\"myCard myCell\">" +
                    "    <div class=\"myCharacter\">"+grid[row][col].value+"</div>" +
                    "    <div class=\"myPoint\">"+point[grid[row][col].value]+"</div>" +
                    "</div>"
            } else {
                if(grid[row][col].kind === "t") {
                    html+="<div class=\"myCell triple\">x3</div>"
                } else if(grid[row][col].kind === "d") {
                    html+="<div class=\"myCell double\">x2</div>"
                } else {
                    html+="<div class=\"myCell normal\"> </div>"
                }
            }
        }
        html+="</div>"
    }
    $(".myGrid")[0].innerHTML = html
    $("div.inHand").click(function (ev) {
        return recolor(ev.currentTarget, $(".inHand"))
    })

    $(".myCell").not(".myLabel").click(function (ev) {
        if (!ev.currentTarget.classList.contains("activeDiv")) {
            return recolor(ev.currentTarget, $(".myCell"))
        } else {
            return setCard()
        }
    })
}

function updateHand(result) {
    let html2 = ""
    let newhand
    if (result.status === "pA" || result.status === "fc") {
        newhand = result.gameField.playerList.A.hand
    } else {
        newhand = result.gameField.playerList.B.hand
    }

    for (var j = 0;j < newhand.length;j++){
        html2 += "<div class=\"myCard inHand\"> <div class=\"myCharacter\">"+newhand[j].value+"</div>"
            +"<div class=\"myPoint\">"+ point[newhand[j].value]+"</div></div>"
    }
    $(".myHand")[0].innerHTML = html2

    $("div.inHand").click(function (ev) {
        return recolor(ev.currentTarget, $(".inHand"))
    })
}

function updateInfo(result) {
    $("#scoreA .playerpoint")[0].innerHTML = result.gameField.playerList.A.point
    $("#scoreB .playerpoint")[0].innerHTML = result.gameField.playerList.B.point
    if (result.status === "pB") {
        $("#scoreA").removeClass("active")
        $("#scoreB").addClass("active")
    } else {
        $("#scoreA").addClass("active")
        $("#scoreB").removeClass("active")
    }
    $("#stack")[0].innerText = result.gameField.pile.tilepile.length
}

function resize(size) {
    $.ajax({
        method: "GET",
        url: "/scrabble/resize/" + size,

        success: function () {
            $.ajax({
                method: "GET",
                url: "/json",
                dataType: "json",

                success: function (result) {
                    newGrid(result)
                    loadJson()
                }
            })
        }
    })

}

function loadJson() {
    $.ajax({
        method: "GET",
        url: "/json",
        dataType: "json",

        success: function (result) {
            console.log(result)
            updateGrid(result)
            updateHand(result)
            updateInfo(result)
        }
    });
}

function initbtns() {
    $("#3x3").click = function () {return resize(3)}
    $("#9x9").click = function () {return resize(9)}
    $("#15x15").click = function () {return resize(15)}
    $("div.inHand").click(function (ev) {
        return recolor(ev.currentTarget, $(".inHand"))
    })
    $(".myCell").not(".myLabel").click(function (ev) {
        if (!ev.currentTarget.classList.contains("activeDiv")) {
            return recolor(ev.currentTarget, $(".myCell"))
        } else {
            return setCard()
        }
    })

    $("#newGameBtn").click(function() {$.ajax( {
        method: "GET",
        url: "/scrabble/new",
        success: function () {
            $.ajax({
                method: "GET",
                url: "/json",
                dataType: "json",

                success: function (result) {
                    newGrid(result)
                    loadJson()
                }
            })
        }
    })})

    $("#switchBtn").click(function() {$.ajax( {
        method: "GET",
        url: "/json",
        dataType: "json",

        success: function (result) {
            let player = result.status === "pB" ? "B" : "A"
            $.ajax({
                method: "GET",
                url: "/scrabble/switch/" + player,
                success: function (result) {
                    loadJson()
                }
            })
        }
    })})

    $("#submitBtn").click(function() {$.ajax( {
        method: "GET",
        url: "/scrabble/submit",
        success: function () {
            loadJson()
        }
    })})

    $("#undoBtn").click(function() {$.ajax( {
        method: "GET",
        url: "/scrabble/undo",
        success: function () {
            $.ajax({
                method: "GET",
                url: "/json",
                dataType: "json",

                success: function (result) {
                    newGrid(result)
                    loadJson()
                }
            })
        }
    })})

    $("#redoBtn").click(function() {$.ajax( {
        method: "GET",
        url: "/scrabble/redo",
        success: function () {
            $.ajax({
                method: "GET",
                url: "/json",
                dataType: "json",

                success: function (result) {
                    newGrid(result)
                    loadJson()
                }
            })
        }
    })})
}

$( document ).ready(function() {
    console.log( "Document is ready, filling grid" );
    initbtns();
});