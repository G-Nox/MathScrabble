import store from "./store.js";

$(document).ready(function(){
    var app = new Vue({
        el: '#app',
        template: `
        <div>
            <v-player-chooser/>
            <v-grid/>
            <v-hand/>
            <v-info/>
        </div>
        `,
    })
})


Vue.component('v-grid', {
    template: `
        <div>
        {{player}}
            <div class="myGrid">
                 <div class="myRow">
                 <div class="myCell myLabel"> </div>
                    <div v-for="(n, i) in size" class="myCell myLabel">
                        {{ n }}
                    </div>
                 </div>
                 <div v-for="(n, i) in size" class="myRow">
                  <div class="myCell myLabel">{{ n }}</div>
                  <div v-for="m in cells[i]" >
                      <div v-if="m.value" class="myCell myCard" @click="test">
                            <div class="myCharacter">{{m.value}}</div>
                            <div class="myPoint">{{card_point[m.value]}}</div>
                      </div>
                      <div v-else>
                          <div v-if="m.kind === 'n'" class="myCell normal" @click="test">
                            {{m.value}}
                          </div>
                          <div v-if="m.kind === 'd'" class="myCell double" @click="test">
                            {{m.value}}
                          </div>
                          <div v-if="m.kind === 't'" class="myCell triple" @click="test">
                            {{m.value}}
                          </div>
                      </div>
                  </div>
                </div>
            </div>
        </div>
    `,
    data() {return store.state},
    methods: {
        test: function (ev) {
            if (!ev.currentTarget.classList.contains("activeDiv")) {
                return recolor(ev.currentTarget, $(".myCell"))
            } else {
                return setCard()
            }
        },
    }
})

Vue.component('v-hand', {
    template: `
        <div class="myHand">
            <div v-if="player === turn && turn === 'A'" v-for="card in hand.A" class="myCard inHand" @click="chooseCard">
                <div class="myCharacter">{{card.value}}</div>
                <div class="myPoint">{{card_point[card.value]}}</div>
            </div>
            <div v-if="player === turn && turn === 'B'" v-for="card in hand.B" class="myCard inHand" @click="chooseCard">
                <div class="myCharacter">{{card.value}}</div>
                <div class="myPoint">{{card_point[card.value]}}</div>
            </div>
        </div>
    `,
    data() {return store.state},
    methods: {
        chooseCard: function (ev) {
            return recolor(ev.currentTarget, $(".inHand"))
        },
    },
})

Vue.component('v-player-chooser', {
    template: `
        <select v-model="player">
          <option disabled value="">Please select a player</option>
          <option>A</option>
          <option>B</option>
        </select>
    `,
    data() {return store.state},
})

Vue.component('v-info', {
    template: `<div class="info">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="card score active shadow bg-white rounded" id="scoreA">
                                    Player A: <span class="playerpoint">{{point.A}}</span>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card score shadow bg-white rounded" id="scoreB">
                                    Player B: <span class="playerpoint">{{point.B}}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <p>cards in stack: <span id="stack">{{num_pile}}</span></p>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <button type="button" id="newGameBtn" class="btn btn-primary btn-block" @click="newgame">
                                    new game</button>
                                <div class="dropdown show btn-block">
                                    <a class="btn dropdown-toggle btn-primary btn-block" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Resize
                                    </a>
                                    <div class="dropdown-menu btn-block" aria-labelledby="dropdownMenuLink">
                                        <button class="dropdown-item" id="3x3" @click="resize(3)">3x3</button>
                                        <button class="dropdown-item" id="9x9" @click="resize(9)">9x9</button>
                                        <button class="dropdown-item" id="15x15" @click="resize(15)">15x15</button>
                                    </div>
                                </div>
                                <button type="button" id="undoBtn" class="btn btn-secondary btn-block" @click="undo">
                                    undo</button>
                                <button type="button" id="redoBtn" class="btn btn-secondary btn-block" @click="redo">
                                    redo</button>
                                <button type="button" id="switchBtn" class="btn btn-dark btn-block" @click="switch_card">
                                    switch cards</button>
                                <button v-if="player === turn" type="button" id="submitBtn" class="btn btn-success btn-block" @click="submit">
                                    submit</button>
                            </div>
                        </div>
                    </div>
                </div>
    `,
    data() {return store.state},

    methods: {
        newgame: function (ev) {
            $.ajax( {
                method: "GET",
                url: "/scrabble/new",
            })
        },
        resize(size) {
            $.ajax({
                method: "GET",
                url: "/scrabble/resize/" + size,
            })
        },
        undo() {
            $.ajax( {
                method: "GET",
                url: "/scrabble/undo",
            })
        },
        redo() {
            $.ajax( {
                method: "GET",
                url: "/scrabble/redo",
            })
        },
        switch_card() {
            $.ajax({
                method: "GET",
                url: "/scrabble/switch/" + this.player,
            })
        },
        submit() {
            $.ajax({
                method: "GET",
                url: "/scrabble/submit",
            })
        }
}})