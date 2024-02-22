package nl.codecraftr.kata.unusualspending

import nl.codecraftr.kata.unusualspending.Category.Groceries
import nl.codecraftr.kata.unusualspending.Category.Travel
import org.approvaltests.Approvals
import org.junit.jupiter.api.Test

class UnusualSpendingTest {
    @Test
    fun unusualSpendingDetected() {
        val previousMonth = listOf(
                Payment(50, "Albert Heijn", Groceries),
                Payment(100, "Train Ticket", Travel)
        )
        val currentMonth = listOf(
                Payment(100, "Albert Heijn", Groceries),
                Payment(928, "Plane Ticket", Travel),
                Payment(48, "Jumbo", Groceries),
        )

        Approvals.verify(UnusualSpending.statement(previousMonth, currentMonth))
    }
}
