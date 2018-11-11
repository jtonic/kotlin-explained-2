package ro.jtonic.tutorials.kt.kotlinexplained.coursera.one.w5

import ro.jtonic.tutorials.kt.kotlinexplained.eq

fun fibonacci(): Sequence<Int> = sequence {
    var pair = 0 to 1
    while(true) {
        yield(pair.first)
        pair = pair.second to (pair.first + pair.second)
    }
}

fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}


