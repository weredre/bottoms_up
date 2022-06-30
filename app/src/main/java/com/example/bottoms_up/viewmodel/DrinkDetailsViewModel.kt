package com.example.bottoms_up.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottoms_up.model.BottomsUpRepo
import com.example.bottoms_up.model.response.DrinkDetailDTO
import com.example.bottoms_up.view.DrinkDetailsState
import kotlinx.coroutines.launch

class DrinkDetailsViewModel : ViewModel() {
    private val repo by lazy { BottomsUpRepo }

    private val _state = MutableLiveData(DrinkDetailsState())
    val state: LiveData<DrinkDetailsState> get() = _state

    private val _stateList = MutableLiveData<DrinkDetailDTO>()
    val stateList: LiveData<DrinkDetailDTO> get() = _stateList


    fun getDrinks(idDrink: String) {

        viewModelScope.launch {
            val drinkDetailDTO = repo.getDrinkDetails(idDrink)
            _state.value = DrinkDetailsState(categories = drinkDetailDTO.drinks)
            _stateList.value = drinkDetailDTO
        }
    }
}