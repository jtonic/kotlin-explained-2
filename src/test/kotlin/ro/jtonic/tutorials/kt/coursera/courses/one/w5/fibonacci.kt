package ro.jtonic.tutorials.kt.coursera.courses.one.w5

import ro.jtonic.tutorials.kt.kotlinexplained.eq

fun fibonacci(): Sequence<Int> = sequence {
    var a = 0
    yield(a)
    var b = 1
    yield(b)
    while(true) {
        val c = a + b
        a = b
        b = c
        yield(c)
    }
}

fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}


