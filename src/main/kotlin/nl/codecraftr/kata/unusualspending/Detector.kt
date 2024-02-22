package nl.codecraftr.kata.unusualspending

object Detector {
    fun detect(prevMonth: List<Payment>, currentMonth: List<Payment>): List<CategorySpending> {
        val totalSpentPerCategoryPrevMonth = calculateSpendingPerCategory(prevMonth)
        val totalSpentPerCategoryCurrentMonth = calculateSpendingPerCategory(currentMonth)

        return totalSpentPerCategoryPrevMonth.zip(totalSpentPerCategoryCurrentMonth)
                .filter { isUnusual(it.first, it.second) }
                .map { it.second }
    }

    private fun calculateSpendingPerCategory(payments: List<Payment>) = payments.groupBy(Payment::category).mapValues {
        CategorySpending(calculateTotalAmount(it.value), it.key)
    }.values.toList()

    private fun calculateTotalAmount(payments: List<Payment>) = payments.sumOf(Payment::amount)

    private fun isUnusual(prev: CategorySpending, current: CategorySpending) =
            prev.amount * 1.5 <= current.amount
}
