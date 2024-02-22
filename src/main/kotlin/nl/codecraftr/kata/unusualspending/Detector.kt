package nl.codecraftr.kata.unusualspending

object Detector {
    fun detect(prevMonth: List<Payment>, currentMonth: List<Payment>): List<CategorySpending> {
        return prevMonth.zip(currentMonth)
                .filter { isUnusual(it.first, it.second) }
                .map { CategorySpending(it.second.amount, it.second.category) }
    }

    private fun isUnusual(prev: Payment, current: Payment) =
            prev.amount * 1.5 <= current.amount
}
