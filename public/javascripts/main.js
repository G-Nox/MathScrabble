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

function resize(size) {
    document.location.replace("/scrabble/resize/" + size)
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

function newGrid() {
    let cells = $(".myCell").not(".myLabel")
    let index = 0

    for(var i = 0;i < grid.size;i++){
        for(var j = 0;j < grid.size;j++){
            cells[index].classList.remove("myCard")
            if(cells[index].classList.contains("triple")) {
                cells[index].innerHTML = "x3"
            } else if (cells[index].classList.contains("double")) {
                cells[index].innerHTML = "x2"
            } else {
                cells[index].innerHTML = ""
            }
            index ++
        }
    }
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
            loadJson()
            newGrid()
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
            loadJson()
        }
    })})

    $("#redoBtn").click(function() {$.ajax( {
        method: "GET",
        url: "/scrabble/redo",
        success: function () {
            loadJson()
        }
    })})
}

$( document ).ready(function() {
    console.log( "Document is ready, filling grid" );
    initbtns();
});