package com.example.bottoms_up.model.response

data class DrinkDetailsDTO(
    val drinks: List<Drink>
) {
    data class Drink(
        val idDrink: String,
        val strDrink: String,
        val strDrinkThumb: String
    )
}