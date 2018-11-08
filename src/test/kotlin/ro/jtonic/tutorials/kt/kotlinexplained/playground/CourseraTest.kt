package ro.jtonic.tutorials.kt.kotlinexplained.playground

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

/**
 * Created by Antonel Ernest Pazargic on 2018-10-26.
 * @author Antonel Ernest Pazargic
 */
class CourseraTest : StringSpec({
    fun isPercentage(number: Int) = if (number in 1..100) {
        true
    } else {
        throw ArithmeticException()
    }

    "is percentage 1" {
        shouldThrow<ArithmeticException> {
            isPercentage(-1)
        }
    }

    "is percentage 2" {
        isPercentage(9) shouldBe true
    }
})
