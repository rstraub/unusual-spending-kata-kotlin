package nl.codecraftr.kata.unusualspending

object EmailBuilder {
    fun build(unusual: List<UnusualCategory>): String {
        return """
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

    private fun lines(unusual: List<UnusualCategory>) =
            unusual.joinToString("\n") {
                "* You spent \$${it.amount} on ${it.category.name.lowercase()}"
            }
}
