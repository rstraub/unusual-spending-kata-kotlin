package nl.codecraftr.kata.unusualspending

object Detector {
    fun detect(prevMonth: List<Payment>, currentMonth: List<Payment>): List<Pair<Int, Category>> {
        val prev = prevMonth.first()
        val current = currentMonth.first()

        return if (isUnusual(prev, current))
            listOf(current.amount to current.category)
        else
            emptyList()
    }

    private fun isUnusual(prev: Payment, current: Payment) =
            prev.amount * 1.5 <= current.amount
}
