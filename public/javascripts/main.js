$("#3x3").click = function () {
    return resize(3)
}
$("#9x9").onclick = function () {
    return resize(9)
}
$("#15x15").onclick = function () {
    return resize(15)
}

let handarr = $(".inHand")
let cellarr = $(".myCell")
let rowarr = $(".myRow")


for (var i = 0; i < handarr.length; i++) {
    let element = handarr[i]

    element.onclick = function () {
        return recolor(element, handarr)
    }
}

for (var i = 0; i < cellarr.length; i++) {
    let name = cellarr[i].className
    let element = cellarr[i]
    if (!name.includes("myLabel")) {
        element.onclick = function () {
            if (!element.classList.contains("activeDiv")) {
                return recolor(element, cellarr)
            } else {
                return setCard()
            }
        }
    }
}


function recolor(element, arr) {
    for (var i = 0; i < arr.length; i++) {
        arr[i].classList.remove("activeDiv")
    }
    element.classList.add("activeDiv")
}

function setCard() {
    let active = isActive(handarr)
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
    handarr = document.getElementsByClassName("inHand")
    cellarr = document.getElementsByClassName("myCell")
    rowarr = document.getElementsByClassName("myRow")
}