package com.rg.mealzapp.Services

import android.util.Log
import com.rg.mealzapp.interfaces.IMealsApiService
import com.rg.mealzapp.model.MealCategoryResponse
import com.rg.mealzapp.ui.Constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsService {
    private  var api : IMealsApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api =retrofit.create(IMealsApiService::class.java)
    }

   suspend fun getMealCategories() : MealCategoryResponse
    {
       val meal =  api.getMealCatogeries()
        Log.d("Test", meal.toString())
        return meal;
    }
}