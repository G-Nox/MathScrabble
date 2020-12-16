function recolor(element, arr) {
    arr.removeClass("activeDiv")
    element.classList.add("activeDiv")
}

function setCard() {
    let active = isActive($(".inHand"))
    if (active[0]) {
        for (var i = 0; i < $(".myRow").length; i++) {
            let row = $(".myRow")[i]
            let cells = row.getElementsByClassName("myCell")
            let activerow = isActive(cells)
            if (activerow[0]) {
                let activeCard = active[1]
                let url = "/scrabble/set/" + (i - 1) + "/" + (activerow[1] - 1) + "/" + activeCard
                $.ajax({
                    method: "GET",
                    url: url,
                    success: function () {
                        loadJson()
                    }
                });
            }
        }
    } else {
        alert("No card was selected")
    }
}

function isActive(array) {
    for (var i = 0; i < array.length; i++) {
        let element = array[i]
        if (element.classList.contains("activeDiv")) {
            return [true, i]
        }
    }
    return false
}

class Grid {
    constructor(size) {
        this.size = size
        this.cells = []
    }

    fill(json){
        for(let i = 0; i < this.size;i++){
            let arr = json[i]
            let data = []
            for(let j = 0;j < arr.length;j++) {
                data[j] = [arr[j].value, arr[j].kind]
            }
            this.cells[i] = data
        }
    }
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
                    //updateGrid(result)
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
            // grid_size = Object.keys(result.gameField.grid.cells).length
            // grid = new Grid(grid_size)
            // grid.fill(result.gameField.grid.cells)
            // updateGrid(result)
            // updateHand(result)
            updateInfo(result)
        }
    });
}

function initbtns() {
    let isCurrentPlayer = function(result) {
        let player = result.status === "pB" ? "B" : "A"
        return player === client_player
    }

    $("#newGameBtn").click(function() {$.ajax( {
        method: "GET",
        url: "/scrabble/new",
        success: function () {
            $.ajax({
                method: "GET",
                url: "/json",
                dataType: "json",

                success: function (result) {
                    // updateGrid(result)
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
            let currentPlayer = result.status==="pB"?"B":"A"
           // if(isCurrentPlayer(result)) {
                $.ajax({
                    method: "GET",
                    url: "/scrabble/switch/" + currentPlayer,
                    success: function () {
                        loadJson()
                    }

                })
            //} else {
            //    alert("not your turn")
           // }
        }
    })})

    $("#submitBtn").click(function() {$.ajax( {
        method: "GET",
        url: "/json",
        dataType: "json",
        success: function (result) {
            if(!isCurrentPlayer(result)) {
                $.ajax({
                    method: "GET",
                    url: "/scrabble/submit",
                    success: function () {
                        loadJson()
                    }
                })
            } else {
                alert("not your turn")
            }
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
                    // updateGrid(result)
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
                    // updateGrid(result)
                    loadJson()
                }
            })
        }
    })})
    $("#3x3").click(function () {return resize(3)})
    $("#9x9").click(function () {return resize(9)})
    $("#15x15").click(function () {return resize(15)})

    $("div.inHand").click(function (ev) {$.ajax( {
        method: "GET",
        url: "/json",
        dataType: "json",
        success: function (result) {
            if(isCurrentPlayer(result)) {
                return recolor(ev.currentTarget, $(".inHand"))
            } else {
                alert("not your turn")
            }
        }
    })})

    $(".myCell").not(".myLabel").click(function (ev) {
        $.ajax( {
            method: "GET",
            url: "/json",
            dataType: "json",
            success: function (result) {
                if(isCurrentPlayer(result)) {
                    if (!ev.currentTarget.classList.contains("activeDiv")) {
                        return recolor(ev.currentTarget, $(".myCell"))
                    } else {
                        return setCard()
                    }
                } else {
                    alert("not your turn")
                }
            }
        })})
}

$( document ).ready(function() {
    console.log( "Document is ready, filling grid" );
    initbtns()
});