@file:JvmName("Utils")

package ro.jtonic.tutorials.kt.kotlinexplained.arrow

/**
 * Created by Antonel Ernest Pazargic on 2018-10-25.
 * @author Antonel Ernest Pazargic
 */

fun sum(a: Int, b: Int) = a + b

fun displayCharacter(ch: Char = '*', times: Int = 10) {
    repeat(times) {
        print(ch)
    }
    println()
}

fun main(args: Array<String>) {
    val a: String
    val b = 1
    if (b == 0) {
        a = "no"
    } else {
        a = "yes"
    }
    println("a = $a")

    displayCharacter()
    displayCharacter(times = 2, ch = 'a')
    displayCharacter(times = 10)
    displayCharacter('#')
    displayCharacter('#', 3)
}
