package com.example.unit4.data

object MenuData {
    val entrees = listOf(
        MenuItem("Caesar Salad", "Fresh romaine lettuce with Caesar dressing", 7.5),
        MenuItem("Grilled Chicken", "Served with rice and vegetables", 8.99),
        MenuItem("Spaghetti Bolognese", "Classic Italian pasta with meat sauce", 9.49)
    )

    val sides = listOf(
        MenuItem("French Fries", "Crispy golden fries", 3.5),
        MenuItem("Coleslaw", "Creamy coleslaw salad", 2.99),
        MenuItem("Garlic Bread", "Toasted bread with garlic butter", 2.5)
    )

    val accompaniments = listOf(
        MenuItem("Iced Tea", "Sweetened iced tea", 1.99),
        MenuItem("Lemonade", "Freshly squeezed lemonade", 2.49),
        MenuItem("Water", "Just water, free and pure", 0.0)
    )
}
