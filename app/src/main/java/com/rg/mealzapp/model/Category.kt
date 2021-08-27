package com.rg.mealzapp.model
import com.google.gson.annotations.SerializedName
data class Category(

   @SerializedName("idCategory") val id: Int,
   @SerializedName("strCategory")val name: String,
   @SerializedName("strCategoryThumb")val imageUrl: String,
   @SerializedName("strCategoryDescription")val description: String)

