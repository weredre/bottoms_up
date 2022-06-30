package com.example.bottoms_up.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottoms_up.model.BottomsUpRepo
import com.example.bottoms_up.model.response.CategoryDTO
import com.example.bottoms_up.view.CategoryState
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    private val repo by lazy { BottomsUpRepo }

    private val _state = MutableLiveData(CategoryState())
    val state: LiveData<CategoryState> get() = _state


    private val _stringList = MutableLiveData<CategoryDTO>()
    val stringList: LiveData<CategoryDTO> get() = _stringList


    init {
        viewModelScope.launch {
            val categoryDTO = repo.getCategories()
            _state.value = CategoryState(categories = categoryDTO.categoryItems)
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            val category = repo.getCategories()
            _stringList.value = category
        }

    }

}