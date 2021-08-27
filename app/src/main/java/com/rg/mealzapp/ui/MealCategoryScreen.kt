package com.rg.mealzapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.rg.mealzapp.model.Category
import com.rg.mealzapp.viewmodels.MealCategoryViewModel


    @Composable
    fun CategoryListScreen() {
        val mealCategoryViewModel: MealCategoryViewModel = viewModel()
        val meals = mealCategoryViewModel.categoriesState.value
        LazyColumn {
            items(meals)
            { meal ->
                CategoryItem(meal = meal)
            }
        }
    }

    @Composable
    fun CategoryName(mealName: String , size : TextUnit) {
        Text(text = mealName,
            style = MaterialTheme.typography.h5,
            fontSize = size,
            modifier = Modifier.padding(8.dp)
        )
    }

    @Composable
    fun CategoryItem(meal : Category) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            elevation = 5.dp
        )
        {
            Column() {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    meal?.imageUrl?.let { CategoryImage(imageUrl = it) }
                    meal?.name?.let { CategoryName(mealName = it, 25.sp) }
                }

                CategoryName(mealName = meal.description, size = 12.sp)
            }




        }
    }

    @Composable
    fun CategoryImage(imageUrl: String) {
        Image( painter = rememberImagePainter (data = imageUrl),
            contentDescription = "Meal Image",
            modifier = Modifier
                .size(70.dp)
                .padding(10.dp)
        )

    }

    @Preview(showBackground = true)
    @Composable
    fun ProfileDetailPreview() {

    }