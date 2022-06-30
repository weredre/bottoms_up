package com.example.bottoms_up.model.response

import com.google.gson.annotations.SerializedName

data class CategoryDTO(
    @SerializedName("drinks")
    val categoryItems: List<CategoryItem>
) {
    data class CategoryItem(
        val strCategory: String
    )
}