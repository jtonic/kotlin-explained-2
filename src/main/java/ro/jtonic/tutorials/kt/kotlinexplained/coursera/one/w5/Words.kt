package ro.jtonic.tutorials.kt.kotlinexplained.coursera.one.w5

import ro.jtonic.tutorials.kt.kotlinexplained.eq

class Words {
    private val list = mutableListOf<String>()

    override fun toString() = list.toString()

    fun String.record() {
        list += this
    }

    operator fun String.unaryPlus() {
        this.record()
    }
}


fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    words.toString() eq "[one, two]"
}
