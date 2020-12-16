const store = {
    state: {
        size: 15,
        cells: [],
        turn: "",
        player: "",
        hand: {
            A: [],
            B: [],
        },
        point: {
            A: 0,
            B: 0,
        },
        num_pile: 0,
    },
    setGrid(size, cells) {
        this.state.size = size
        this.state.cells = cells
    },
    setPlayer(player) {
        this.state.player = player
    },
    setHand(player, hand) {
        if(player === "A") {
            this.state.hand.A = hand
        } else if (player === "B") {
            this.state.hand.B = hand
        }
    },
    setPoint(player, point) {
        if(player === "A") {
            this.state.point.A = point
        } else if (player === "B") {
            this.state.point.B = point
        }
    },
    setPile(pile){
        this.state.num_pile = pile
    },
    setTurn(turn) {
        this.state.turn = turn
    }
}

function connectWebSocket() {
    var websocket = new WebSocket("ws://localhost:9000/websocket");

    websocket.onopen = function(event) {
        console.log(event)
        console.log("Connected to Websocket")
        websocket.send("a")
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
                    store.setGrid(res.gameField.grid.cells.length, res.gameField.grid.cells)
                    console.log(store.state.cells)

            }
        }
    };

    window.onbeforeunload = function (){
        websocket.send("disconnected player " + client_player)
    }
}

$( document ).ready(function() {
    connectWebSocket()
});

export default store;