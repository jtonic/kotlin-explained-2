package ro.jtonic.tutorials.kt.coursera.courses.one.w5

import org.junit.Test
import java.util.*
import kotlin.coroutines.experimental.buildSequence

/**
 * Created by Antonel Ernest Pazargic on 08/11/2018.
 * @author Antonel Ernest Pazargic
 */
class SequencesTest {

    @Test
    fun `generate random seq 1`() {
        val seq = generateSequence {
            Random().nextInt().takeIf { it > 0 }
        }
        for (num in seq) {
            println("num = $num")
        }
    }

    @Test
    fun `generate seq 2`() {
        val seq = generateSequence {
            val genNum = Random().nextInt().takeIf { it > 0 }
            println("genNum = $genNum")
            genNum
        }
        for (num in seq) {
            println("num = $num")
        }
    }

    @Test
    fun `generate seq 3`() {
        val seq = generateSequence(0) { it + 1 }
        seq.take(5).forEach {
            println("num = $it")
        }
    }

    @Test
    fun `generate seq 4`() {
        val seq = generateSequence(3) { n ->
            println("generate sequence")
            (n + 1).takeIf { it <= 0 }
        }
        println(seq.first())
    }

    @Test
    fun `generate seq with yield 1`() {
        val seq = buildSequence {
            var x = 0
            while (true) {
                yield(x++)
            }
        }
        seq.take(3).forEach(::println)
    }

    @Test
    fun `generate seq with yield 2`() {
        val seq = buildSequence {
            println("yield value")
            yield(1)
            println("yield from a range")
            yieldAll(3..5)
            println("yield from a list")
            yieldAll(listOf(7, 8, 9))
        }

        val first = seq.map { it * it }.filter { it > 10 }.first()
        println(first)
    }
}
