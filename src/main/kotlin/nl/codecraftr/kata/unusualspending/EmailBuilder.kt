package nl.codecraftr.kata.unusualspending

object EmailBuilder {
    fun build(unusual: List<UnusualCategory>): String {
        return """
            Hello card user!

            We have detected unusually high spending on your card in these categories:

            * You spent $10 on groceries
            * You spent $15 on travel

            Love,

            The Credit Card Company

        """.trimIndent()
    }

}
