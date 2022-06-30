package com.example.bottoms_up.model.remote

import com.example.bottoms_up.model.response.CategoryDTO
import com.example.bottoms_up.model.response.DrinkDetailsDTO
import com.example.bottoms_up.model.response.DrinkDetailDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface BottomsUpService {

    companion object {
        private const val BASE_URL = "https://www.thecocktaildb.com"

        fun getInstance(): BottomsUpService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create()
        }
    }

    suspend fun getMockData(): List<String>


    @GET("/api/json/v1/1/list.php")
    suspend fun getCategories(@Query("c") type: String = "list"): CategoryDTO

    @GET("/api/json/v1/1/filter.php")
    suspend fun getCategoryDrinks(@Query("c") category: String): DrinkDetailsDTO

    @GET("api/json/v1/1/lookup.php")
    suspend fun getDrinkDetails(@Query("i")category: String) :DrinkDetailDTO


}