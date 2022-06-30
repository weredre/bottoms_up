package com.example.bottoms_up.view

import com.example.bottoms_up.model.response.DrinkDetailDTO

data class DrinkDetailsState(
    val categories: List<DrinkDetailDTO.Drink> = emptyList()
)
