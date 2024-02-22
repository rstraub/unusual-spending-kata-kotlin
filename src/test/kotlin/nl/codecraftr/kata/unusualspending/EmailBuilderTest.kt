package nl.codecraftr.kata.unusualspending

import io.kotest.matchers.shouldBe
import nl.codecraftr.kata.unusualspending.Category.Groceries
import nl.codecraftr.kata.unusualspending.Category.Travel
import org.junit.jupiter.api.Test

class EmailBuilderTest {
    @Test
    fun `should build a message given unusual spending`() {
        val unusual = listOf(
                UnusualCategory(10, Groceries),
                UnusualCategory(15, Travel)
        )

        val result  = EmailBuilder.build(unusual)

        result shouldBe """
            Hello card user!

            We have detected unusually high spending on your card in these categories:

            * You spent $10 on groceries
            * You spent $15 on travel

            Love,

            The Credit Card Company

        """.trimIndent()
    }

    @Test
    fun `should do something given no unusual spending`() {
        EmailBuilder.build(emptyList()) shouldBe null
    }
}
