package nl.codecraftr.kata.unusualspending

object EmailBuilder {
    fun build(unusual: List<CategorySpending>): String? {
        return if (unusual.isEmpty()) null
        else
            """
            |Hello card user!
            |
            |We have detected unusually high spending on your card in these categories:
            |
            |${lines(unusual)}
            |
            |Love,
            |
            |The Credit Card Company

        """.trimMargin()
    }

    private fun lines(unusual: List<CategorySpending>) =
            unusual.joinToString("\n") {
                "* You spent \$${it.amount} on ${it.category.name.lowercase()}"
            }
}
