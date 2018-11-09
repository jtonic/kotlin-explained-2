import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class KtLibraryTest {

    data class Person(val name: String, val age: Int)

    @Test
    fun `simplification 1`() {

        val people = listOf(Person("Tony", 48), Person("Magda", 45), Person("Irina", 28), Person("Balas", 48))

        val nums = listOf(1, 3, 10, 4)
        nums.filter{ it < 4 }.size shouldBe 2

        nums.fold(0) { acc, i -> if (i < 4) acc + 1 else acc } shouldBe 2

        nums.count { it < 4 } shouldBe 2

        nums.sortedDescending() shouldBe listOf(10, 4, 3, 1)

        val olderPeople = people
                .mapNotNull { person ->
                    person.takeIf { it.age > 40 }?.name
                }
        println(olderPeople)

        val groups = mutableMapOf<Int, MutableList<Person>>()
        for (person in people) {
            val group = groups.getOrPut(person.age) { mutableListOf() }
            group += person
        }
        println(groups)
    }
}
