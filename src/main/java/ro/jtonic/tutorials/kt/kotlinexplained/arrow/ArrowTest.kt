/*
package ro.jtonic.tutorials.kt.kotlinexplained.arrow

import arrow.core.Tuple2
import arrow.core.toT
import arrow.data.State
import arrow.data.ev
import arrow.instances.monad
import arrow.typeclasses.binding
import org.junit.Test

*/
/**
 * Created by Antonel Ernest Pazargic on 06/04/2018.
 * @author Antonel Ernest Pazargic
 *//*


// ===============================================
// ======= disclosure  ===========================
// The code is from the Functional Kotlin book
// ===============================================
typealias PriceLog = MutableList<Tuple2<String, Double>>

class ArrowTest {

    @Test
    fun `arrow State monad`() {
        fun addVat(): State<PriceLog, Unit> = State { log: PriceLog ->
            val (_, price) = log.last()
            val vat = price * 0.2
            log.add("Add VAT: $vat" toT price + vat)
            log toT Unit
        }

        fun finalPrice(): State<PriceLog, Double> = State { log ->
            val (_, price) = log.last()
            log.add("Final Price" toT price)
            log toT price
        }

        fun calculatePrice(threshold: Double, discount: Double) =
                State().monad<PriceLog>().binding {
                    addVat().bind() //Unit
                    val price: Double = finalPrice().bind()
                    price
                }.ev()

        */
/*val (history: PriceLog, price: kotlin.Double) = calculatePrice(100.0, 2.0).run(mutableListOf("Init" toT 15.0))
        println("Price: $price")
        println("::History::")
        history
                .map { (text, value) -> "$text\t|\t$value" }
                .forEach(::println)

        val bigPrice: Double = calculatePrice(100.0, 2.0).runA(mutableListOf("Init" toT 1000.0))
        println("bigPrice = $bigPrice")*//*

    }
}
*/
