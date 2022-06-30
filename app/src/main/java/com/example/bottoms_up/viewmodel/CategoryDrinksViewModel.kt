package com.example.bottoms_up.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottoms_up.model.BottomsUpRepo
import com.example.bottoms_up.model.response.DrinkDetailsDTO
import com.example.bottoms_up.view.CategoryDrinksState
import kotlinx.coroutines.launch

class CategoryDrinksViewModel: ViewModel() {

    private val repo by lazy { BottomsUpRepo }

    private val _state = MutableLiveData(CategoryDrinksState())
    val state: LiveData<CategoryDrinksState> get() = _state

    private val _stateList = MutableLiveData<DrinkDetailsDTO>()
    val stateList: LiveData<DrinkDetailsDTO> get() = _stateList

    fun getDrinks(category: String) {

        viewModelScope.launch {
            val categoryDrinksDTO = repo.getCategoryDrinks(category)
            _state.value = CategoryDrinksState(categories = categoryDrinksDTO.drinks)
            _stateList.value = categoryDrinksDTO
        }
    }
}