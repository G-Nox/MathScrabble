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

function loadJson() {
    $.ajax({
        method: "GET",
        url: "/json",
    });
}

$( document ).ready(function() {
    console.log( "Document is ready, filling grid" );
});