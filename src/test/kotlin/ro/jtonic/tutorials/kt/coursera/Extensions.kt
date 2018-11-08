package ro.jtonic.tutorials.kt.coursera

/**
 * Created by Antonel Ernest Pazargic on 08/11/2018.
 * @author Antonel Ernest Pazargic
 */

infix fun Boolean.eq(check: Boolean): Unit = if (this == check) println("OK") else println("NOT OK")
