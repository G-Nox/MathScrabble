function recolor(element, arr) {
    arr.removeClass("activeDiv")
    element.classList.add("activeDiv")
}

function setCard() {
    let rowarr = $(".myRow")
    let active = isActive($(".inHand"))
    if (active[0]) {
        for (var i = 0; i < rowarr.length; i++) {
            let row = rowarr[i]
            let cells = row.getElementsByClassName("myCell")
            activerow = isActive(cells)
            if (activerow[0]) {
                console.log([activerow[1],i])
                let activeCard = active[1]
                let url = "/scrabble/set/" + (activerow[1] - 1) + "/" + (i - 1) + "/" + activeCard
                document.location.replace(url)
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

function resize(size) {
    document.location.replace("/scrabble/resize/" + size)
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
}

$( document ).ready(function() {
    console.log( "Document is ready, filling grid" );
    initbtns();
});