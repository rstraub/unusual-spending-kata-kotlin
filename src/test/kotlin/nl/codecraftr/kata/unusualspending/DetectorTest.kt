package nl.codecraftr.kata.unusualspending

import io.kotest.matchers.shouldBe
import nl.codecraftr.kata.unusualspending.Category.Groceries
import org.junit.jupiter.api.Test

class DetectorTest {
    @Test
    fun `should detect unusual spending given over 50% increase within category`() {
        val prevMonth = listOf(Payment(10, "test", Groceries))
        val currentMonth = listOf(Payment(15, "test", Groceries))

        val result = Detector.detect(prevMonth, currentMonth)

        result shouldBe Pair(15, Groceries)
    }
}
