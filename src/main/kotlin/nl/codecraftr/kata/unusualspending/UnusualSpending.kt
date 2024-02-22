package nl.codecraftr.kata.unusualspending

object UnusualSpending {
    fun statement(previousMonth: List<Payment>, currentMonth: List<Payment>): String? {
        val unusual = Detector.detect(previousMonth, currentMonth)
        val message = EmailBuilder.build(unusual)
        return message
    }
}
