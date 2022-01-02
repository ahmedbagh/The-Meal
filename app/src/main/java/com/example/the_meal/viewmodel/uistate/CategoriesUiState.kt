package com.example.the_meal.uistate

import com.example.the_meal.data.model.CategoryApiModel

data class CategoriesUiState(
    val isLoading : Boolean = false,
    val categories : List<CategoryApiModel> = listOf()
)
