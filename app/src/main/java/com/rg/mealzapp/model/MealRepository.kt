package com.rg.mealzapp.model

import com.rg.mealzapp.Services.MealsService

class MealRepository(private val mealApiService: MealsService = MealsService()) {
    suspend fun getMealCategory() : MealCategoryResponse
    {
       return mealApiService.getMealCategories()
    }
}