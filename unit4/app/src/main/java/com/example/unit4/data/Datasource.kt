package com.example.unit4.data

object DataSource {
    val entreeMenuItems = listOf(
        MenuItem("Grilled Chicken", "Grilled chicken with herbs", 5.99),
        MenuItem("Pasta Primavera", "Vegetable pasta with sauce", 6.49),
        MenuItem("Beef Steak", "Juicy beef steak", 8.99)
    )

    val sideDishMenuItems = listOf(
        MenuItem("French Fries", "Crispy fries", 2.49),
        MenuItem("Salad", "Fresh vegetable salad", 2.99),
        MenuItem("Soup", "Warm soup", 3.49)
    )

    val accompanimentMenuItems = listOf(
        MenuItem("Iced Tea", "Refreshing iced tea", 1.99),
        MenuItem("Soda", "Sparkling drink", 1.49),
        MenuItem("Water", "Mineral water", 0.99)
    )
}
