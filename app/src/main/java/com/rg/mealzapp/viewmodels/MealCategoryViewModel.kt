package com.rg.mealzapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rg.mealzapp.model.Category
import com.rg.mealzapp.model.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealCategoryViewModel(val mealRepository: MealRepository = MealRepository()) : ViewModel() {
    val categoriesState : MutableState<List<Category>> = mutableStateOf(emptyList())

    init {
            viewModelScope.launch(Dispatchers.IO) {
                val meals = getMealcatogeries()
                categoriesState.value = meals
            }

    }


    private suspend fun getMealcatogeries(): List<Category> {
        return  mealRepository.getMealCategory().categories

    }

}