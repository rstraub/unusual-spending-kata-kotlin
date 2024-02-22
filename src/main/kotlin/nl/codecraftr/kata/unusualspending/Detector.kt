package nl.codecraftr.kata.unusualspending

object Detector {
    fun detect(prevMonth: List<Payment>, currentMonth: List<Payment>): List<CategorySpending> {
        val groupedPrevMonth = toSpendingPerCategory(prevMonth)
        val groupedCurrentMonth = toSpendingPerCategory(currentMonth)

        return groupedPrevMonth.zip(groupedCurrentMonth)
                .filter { isUnusual(it.first, it.second) }
                .map { it.second }
    }

    private fun toSpendingPerCategory(payments: List<Payment>) = payments.groupBy { it.category }.mapValues {
        CategorySpending(it.value.sumOf { p -> p.amount }, it.key)
    }.values.toList()

    private fun isUnusual(prev: CategorySpending, current: CategorySpending) =
            prev.amount * 1.5 <= current.amount
}
