fun main() {
    agoToText(23 * 3600)
}

fun agoToText(interval: Int) {
    var seconds = 0
    if (interval >= 0 && interval < 60) {
        seconds = 1
    } else if (interval >= 60 && interval < 60 * 60) {
        seconds = 2
    } else if (interval >= 60 * 60 && interval < 24 * 60 * 60) {
        seconds = 3
    } else if (interval >= 24 * 60 * 60 && interval < 24 * 2 * 60 * 60) {
        seconds = 4
    } else if (interval >= 24 * 2 * 60 * 60 && interval < 24 * 3 * 60 * 60) {
        seconds = 5
    } else if (interval >= 24 * 3 * 60 * 60) {
        seconds = 6
    }
    when (seconds) {
        1 -> println("был(а) только что")
        2 -> declineMinutes(interval)
        3 -> declineHours(interval)
        4 -> println("был(а) в сети сегодня")
        5 -> println("был(а) в сети вчера")
        6 -> println("был(а) в сети давно")
    }
}

fun declineMinutes(interval: Int) {
    val intervalInMinutes = interval / 60
    val lastCharacter = intervalInMinutes % 10
    val twoLastCharacters = intervalInMinutes % 100
    var s = ""
    if (interval < 60 * 60) {
        if (lastCharacter == 1 && twoLastCharacters != 11) {
            s = "минуту"
        } else if ((twoLastCharacters >= 11 && twoLastCharacters <= 19) || (lastCharacter >= 5 && lastCharacter <= 9) || lastCharacter == 0) {
            s = "минут"
        } else {
            s = "минуты"
        }

        println("был(а) в сети $intervalInMinutes $s назад")
    }
}

fun declineHours(interval: Int) {
    val intervalInHours = interval / 3600
    val lastCharacter = intervalInHours % 10
    val twoLastCharacters = intervalInHours % 100
    var s = ""
    if (lastCharacter == 1 && twoLastCharacters != 11) {
        s = "час"
    } else if ((twoLastCharacters >= 11 && twoLastCharacters <= 19) || (lastCharacter >= 5 && lastCharacter <= 9) || lastCharacter == 0) {
        s = "часов"
    } else {
        s = "часа"
    }

    println("был(а) в сети $intervalInHours $s назад")
}