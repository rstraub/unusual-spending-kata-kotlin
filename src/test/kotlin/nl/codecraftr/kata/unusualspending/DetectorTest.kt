package nl.codecraftr.kata.unusualspending

import io.kotest.matchers.shouldBe
import nl.codecraftr.kata.unusualspending.Category.Groceries
import nl.codecraftr.kata.unusualspending.Category.Travel
import org.junit.jupiter.api.Test

class DetectorTest {
    @Test
    fun `should flag unusual spending given over 50% increase within category`() {
        val prevMonth = listOf(Payment(10, "test", Groceries))
        val currentMonth = listOf(Payment(15, "test", Groceries))

        val result = Detector.detect(prevMonth, currentMonth)

        result shouldBe listOf(UnusualCategory(15, Groceries))
    }

    @Test
    fun `should flag unusual spending in multiple categories`() {
        val prevMonth = listOf(
                Payment(10, "test", Groceries),
                Payment(20, "test", Travel))
        val currentMonth = listOf(
                Payment(15, "test", Groceries),
                Payment(30, "test", Travel))

        val result = Detector.detect(prevMonth, currentMonth)

        result shouldBe listOf(UnusualCategory(15, Groceries),
                UnusualCategory(30, Travel))
    }

    @Test
    fun `should flag unusual spending using the sum of all payments with a category`() {
        val prevMonth = listOf(Payment(10, "test", Groceries))
        val currentMonth = listOf(
                Payment(10, "test", Groceries),
                Payment(5, "test", Groceries))

        val result = Detector.detect(prevMonth, currentMonth)

        result shouldBe listOf(UnusualCategory(15, Groceries))
    }

    @Test
    fun `should not flag spending given under 50% increase within category`() {
        val prevMonth = listOf(
                Payment(10, "test", Groceries))
        val currentMonth = listOf(
                Payment(14, "test", Groceries))

        val result = Detector.detect(prevMonth, currentMonth)

        result shouldBe listOf()
    }
}
