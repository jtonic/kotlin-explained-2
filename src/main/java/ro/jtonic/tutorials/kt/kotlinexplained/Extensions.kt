package ro.jtonic.tutorials.kt.kotlinexplained

/**
 * Created by Antonel Ernest Pazargic on 08/11/2018.
 * @author Antonel Ernest Pazargic
 */

infix fun Boolean.eq(check: Boolean): Unit = if (this == check) println("OK") else println("NOT OK")

infix fun String.eq(str: String) = println(if (this == str) "OK" else "NOT_OK")

