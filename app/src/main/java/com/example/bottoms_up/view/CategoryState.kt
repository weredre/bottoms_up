package com.example.bottoms_up.view

import com.example.bottoms_up.model.response.CategoryDTO


data class CategoryState (
    val categories: List<CategoryDTO.CategoryItem> = emptyList()
)