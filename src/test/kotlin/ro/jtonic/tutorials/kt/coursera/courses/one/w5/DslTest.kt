package ro.jtonic.tutorials.kt.coursera.courses.one.w5

import io.kotlintest.shouldBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 2018-11-09.
 * @author Antonel Ernest Pazargic
 */
class DslTest {

    @Test
    fun `lambdas with receiver`() {
        val lastChar: String.() -> Char = { this[this.length - 1] }

        "Antonel".lastChar() shouldBe 'l'

        buildString {
            append("Antonel")
            append(" is a kotlin")
            append(" master.")
        } shouldBe "Antonel is a kotlin master."

    }
}
