import store from "./store.js";

$(document).ready(function(){
    var app = new Vue({
        el: '#app',
        template: `
        <div>
            <div class="container my-4">
                <div class="row">
                    <div class="col">
                        <v-grid/>
                        <v-hand/>
                    </div>
                    <div class="col">
                        <v-info/>
                    </div>
                </div>
            </div>
        </div>
        `,
    })
})


Vue.component('v-grid', {
    template: `
        <div class="myGrid bg-white rounded card">
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
        <div v-if="player === turn" class="myHand rounded my-2">
            <div v-if="player === 'A'" v-for="card in hand.A" class="myCard inHand" @click="chooseCard">
                <div class="myCharacter">{{card.value}}</div>
                <div class="myPoint">{{card_point[card.value]}}</div>
            </div>
            <div v-if="player === 'B'" v-for="card in hand.B" class="myCard inHand" @click="chooseCard">
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
                    <div class="mb-2">
                        <div class="row">
                            <div class="col pr-1">
                                <div class="card p-3 bg-white rounded" :class="{active: isPlayerA}">
                                    Player A: <span class="playerpoint">{{point.A}}</span>
                                </div>
                            </div>
                            <div class="col pl-1">
                                <div class="card p-3 bg-white rounded" :class="{active: !isPlayerA}">
                                    Player B: <span class="playerpoint">{{point.B}}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="my-2">
                        <div class="card bg-white p-3">
                            <p>cards in stack: {{pile}}</p>
                            <p>you are player: {{player}}</p>
                            <v-player-chooser/>
                        </div>
                    </div>
                    <v-buttons/>
                </div>
    `,
    data() {return store.state},
    computed: {
        isPlayerA() {
            return this.turn === 'A'
        }
    },
})

Vue.component('v-buttons', {
    template: `
        <div class="my-2">
            <div class="row">
                <div class="col">
                    <button type="button" class="btn btn-primary btn-block" @click="newgame">
                        new game</button>
                    <div class="dropdown show btn-block">
                        <a class="btn dropdown-toggle btn-primary btn-block" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Resize
                        </a>
                        <div class="dropdown-menu btn-block" aria-labelledby="dropdownMenuLink">
                            <button class="dropdown-item" @click="resize(3)">3x3</button>
                            <button class="dropdown-item" @click="resize(9)">9x9</button>
                            <button class="dropdown-item" @click="resize(15)">15x15</button>
                        </div>
                    </div>
                    <button type="button" class="btn btn-secondary btn-block" @click="undo">
                        undo</button>
                    <button type="button" class="btn btn-secondary btn-block" @click="redo">
                        redo</button>
                    <button type="button" class="btn btn-dark btn-block" @click="switch_card">
                        switch cards</button>
                    <button v-if="player === turn" type="button" class="btn btn-success btn-block" @click="submit">
                        submit</button>
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
    }
})