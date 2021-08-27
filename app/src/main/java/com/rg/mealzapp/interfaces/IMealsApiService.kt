package com.rg.mealzapp.interfaces

import com.rg.mealzapp.model.MealCategoryResponse
import com.rg.mealzapp.ui.Constants.Constants
import retrofit2.http.GET

interface IMealsApiService {

    @GET(Constants.CATEGORIES)
    suspend fun getMealCatogeries() : MealCategoryResponse

}