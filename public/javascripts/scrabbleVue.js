import store from "./store.js";

$(document).ready(function(){
    var app = new Vue({
        el: '#app',
        template: `
        <div>
            <v-player-chooser/>
            <v-grid/>
        </div>
        `,
    })
})


Vue.component('v-grid', {
    template: `
        <div>
        {{player}}
            <div class="myGrid">
                 <div class="myCol">
                 <div class="myCell myLabel"> </div>
                    <div v-for="(n, i) in size" class="myCell myLabel">
                        {{ n }}
                    </div>
                 </div>
                 <div v-for="(n, i) in size" class="myCol">
                  <div class="myCell myLabel">{{ n }}</div>
                  <div v-for="m in cells[i]" >
                      <div v-if="m.value" class="myCell myCard" @click="test">
                            <div class="myCharacter">{{m.value}}</div>
                            <div class="myPoint">{{m.value}}</div>
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
            $.ajax( {
                method: "GET",
                url: "/json",
                dataType: "json",
                success: function (result) {
                    if(this.isCurrentPlayer(result)) {
                        if (!ev.currentTarget.classList.contains("activeDiv")) {
                            return recolor(ev.currentTarget, $(".myCell"))
                        } else {
                            return setCard()
                        }
                    } else {
                        alert("not your turn")
                    }
                }
            })
        },
        isCurrentPlayer(result) {
            let p = result.status === "pB" ? "B" : "A"
            return p === this.player
        }
    }
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