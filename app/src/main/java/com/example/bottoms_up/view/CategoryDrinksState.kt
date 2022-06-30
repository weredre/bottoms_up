package com.example.bottoms_up.view

import com.example.bottoms_up.model.response.DrinkDetailsDTO

data class CategoryDrinksState(
    val categories: List<DrinkDetailsDTO.Drink> = emptyList()
)
