package com.rg.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.rg.mealzapp.model.Category
import com.rg.mealzapp.ui.theme.MealzAppTheme
import com.rg.mealzapp.viewmodels.MealCategoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    CategoryListScreen()
                }
            }
        }
    }
}

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
fun CategoryName(mealName: String) {
    Text(text = mealName,
        style = MaterialTheme.typography.body2
    )
}

@Composable
fun CategoryItem(meal : Category?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        elevation = 5.dp
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            meal?.imageUrl?.let { CategoryImage(imageUrl = it) }
            meal?.name?.let { CategoryName(mealName = it) }
        }

    }
}

@Composable
fun CategoryImage(imageUrl: String) {
   Image( painter = rememberImagePainter (data = imageUrl,
       builder = {
           transformations(CircleCropTransformation())
       }) , contentDescription = "Meal Image",
       modifier = Modifier.size(70.dp)
           .padding(10.dp)
   )

}

@Preview(showBackground = true)
@Composable
fun ProfileDetailPreview() {
    CategoryItem(null)
}

