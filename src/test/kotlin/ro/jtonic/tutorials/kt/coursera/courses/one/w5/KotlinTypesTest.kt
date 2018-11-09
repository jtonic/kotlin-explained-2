package ro.jtonic.tutorials.kt.coursera.courses.one.w5

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class KotlinTypesTest {

  @Test
  fun `working with arrray`() {

    val ints1 = intArrayOf(1, 2, 3)
    val ints2 = intArrayOf(1, 2, 3)

    val res1 = ints1 == ints2
    res1 shouldBe false

    val res2 = ints1.contentEquals(ints2)
    res2 shouldBe true
  }

  @Test
  fun `Nothing Unit types`() {

    fun fail(msg: String): Nothing {
      throw AssertionError("Error")
    }

    fun validate(no: Int) =
      if (no == 1) {
        "ok"
      } else {
        fail("not 1")
      }
  }
}
