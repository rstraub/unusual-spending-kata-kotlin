package nl.codecraftr.kata.unusualspending

data class Payment(val amount: Int, val description: String, val category: Category)
enum class Category {
    Groceries,
    Travel
}
