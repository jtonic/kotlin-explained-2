package ro.jtonic.tutorials.kt.coursera.courses.one.w2

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import ro.jtonic.tutorials.kt.coursera.courses.one.w2.Week2Test.Gender.FEMALE
import ro.jtonic.tutorials.kt.coursera.courses.one.w2.Week2Test.Gender.MALE
import ro.jtonic.tutorials.kt.kotlinexplained.eq

/**
 * Created by Antonel Ernest Pazargic on 04/11/2018.
 * @author Antonel Ernest Pazargic
 */
class Week2Test {

    data class Hero(val name: String, val age: Int, val gender: Gender?)

    enum class Gender {
        MALE, FEMALE
    }

    @Test
    fun `test last first and theirs variants` () {
        val ones = listOf(2, 3, 1, 0)
        println(ones.last())

        val twos = listOf<Int>()
        println(twos.lastOrNull())

        println(twos.firstOrNull())

        val heroes = listOf(Hero("Tony", 48, MALE), Hero("Magda", 45, FEMALE))
        val name = heroes.firstOrNull { it.age == 45 }?.name
        println("name = $name")

        val (_, old) = heroes.partition { it.age <= 46 }
        println(old.size)

        val oldest = heroes.maxBy { it.age }?.name
        println("oldest = $oldest")

        val heroesByName: Map<String, Hero> = heroes.associateBy { it.name }
        val unknown = heroesByName.getOrElse("unknown") { Hero("Unknown", 0, MALE) }.name
        println("unknown = $unknown")
    }

    @Test
    fun `takeIf and unless`() {

        val num = 2
        num.takeIf { it < 10 } shouldBe 2
        num.takeIf { it > 10 } shouldBe null

        num.takeUnless { it > 10 } shouldBe 2
        num.takeUnless { it < 10 } shouldBe null
    }

    @Test
    fun `functions of collections`() {
        val heroes = listOf(
                Hero("The Captain", 60, MALE),
                Hero("Frenchy", 42, MALE),
                Hero("The Kid", 9, null),
                Hero("Lady Lauren", 29, FEMALE),
                Hero("First Mate", 29, MALE),
                Hero("Sir Stephen", 37, MALE))

        val allPossibleCombinations: (Hero) -> List<Pair<Hero, Hero>> =
                { first -> heroes.map { second -> first to second } }

        val (first, second) = heroes
                .flatMap(allPossibleCombinations)
                .maxBy { it.first.age - it.second.age }!!
        println(first.name)
        println(second.name)
    }

    @Test
    fun `cccc`() {
        val a = listOf(1, 0, 0)
        val nonZero = !(a.any { it == 0 })
        nonZero eq false
        val b = !(listOf(1, 2, 3).any { it == 0 })
        b eq true
    }

    @Test
    fun `test any none all functions`() {


        fun List<Int>.allNonZero() = all { it != 0 }
        fun List<Int>.allNonZero1() = none { it == 0 }
        fun List<Int>.allNonZero2() = !any { it == 0 }

        fun List<Int>.containsZero() = any { it == 0 }
        fun List<Int>.containsZero1() = !all { it != 0 }
        fun List<Int>.containsZero2() = !none { it == 0 }

        val list1 = listOf(1, 2, 3)
        list1.allNonZero() eq true
        list1.allNonZero1() eq true
        list1.allNonZero2() eq true

        list1.containsZero() eq false
        list1.containsZero1() eq false
        list1.containsZero2() eq false

        val list2 = listOf(0, 1, 2)
        list2.allNonZero() eq false
        list2.allNonZero1() eq false
        list2.allNonZero2() eq false

        list2.containsZero() eq true
        list2.containsZero1() eq true
        list2.containsZero2() eq true
    }
}
