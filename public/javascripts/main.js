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

let client_player = ""

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
                let url = "/scrabble/set/" + (activerow[1] - 1) + "/" + (i - 1) + "/" + activeCard
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

// function updateGrid(result){
//     let cells = $(".myCell").not(".myLabel")
//     let index = 0
//     let newcells = result.gameField.grid.cells
//     console.log(newcells)
//
//     for(var i = 0;i < newcells.length;i++){
//         for(var j = 0;j < newcells.length;j++){
//             if(newcells[j][i].value !== "") {
//                 let html = "<div class=\"myCharacter\">"+newcells[j][i].value+"</div>"
//                     +"<div class=\"myPoint\">"+ point[newcells[j][i].value]+"</div>"
//                 cells[index].classList.add("myCard")
//                 cells[index].innerHTML = html
//             }
//             index ++
//         }
//     }
// }

function updateGrid(result) {
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
                    updateGrid(result)
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
            updateGrid(result)
            updateHand(result)
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
                    updateGrid(result)
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
                    updateGrid(result)
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
                    updateGrid(result)
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

function connectWebSocket() {
    var websocket = new WebSocket("ws://localhost:9000/websocket");

    websocket.onopen = function(event) {
        console.log(event)
        console.log("Connected to Websocket")
        websocket.send("PlayerNameRequest")
    }

    websocket.onclose = function (code) {
        console.log(code)
        console.log('Connection with Websocket Closed!');
    };

    websocket.onerror = function (error) {
        console.log('Error in Websocket Occured: ' + error);
    };

    websocket.onmessage = function (e) {
        if (typeof e.data === "string") {
            // console.log(e)
            let res = JSON.parse(e.data)
            switch(res.Event) {
                case "InvalidEquation()":
                    alert("invalid equation")
                    loadJson()
                    break
                case "GridSizeChanged()":
                    updateGrid(res)
                    loadJson()
                    break
                case "PlayerName":
                    client_player = res.Name
                    console.log("player: "+client_player)
                    break
                default:
                    loadJson()
            }
        }
    };

    window.onbeforeunload = function (){
        websocket.send("disconnected player " + client_player)
    }
}

$( document ).ready(function() {
    console.log( "Document is ready, filling grid" );
    initbtns()
    connectWebSocket()
});