package com.example.bottoms_up.model

import com.example.bottoms_up.model.remote.BottomsUpService
import com.example.bottoms_up.model.response.CategoryDTO
import com.example.bottoms_up.model.response.DrinkDetailDTO
import com.example.bottoms_up.model.response.DrinkDetailsDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object BottomsUpRepo {

    private val bottomsUpService: BottomsUpService by lazy { BottomsUpService.getInstance() }

    suspend fun getCategories(): CategoryDTO = withContext(Dispatchers.IO) {
        bottomsUpService.getCategories()
    }

    suspend fun getCategoryDrinks(category: String): DrinkDetailsDTO = withContext(Dispatchers.IO) {
        bottomsUpService.getCategoryDrinks(category)
    }
    suspend fun getDrinkDetails(idDrink: String): DrinkDetailDTO = withContext(Dispatchers.IO) {
        bottomsUpService.getDrinkDetails(idDrink)
    }


}