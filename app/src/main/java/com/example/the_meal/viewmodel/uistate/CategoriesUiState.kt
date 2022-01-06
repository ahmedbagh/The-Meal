package com.example.the_meal.viewmodel.uistate

import com.example.the_meal.data.model.CategoryApiModel

data class CategoriesUiState(
    val isLoading : Boolean = false,
    val isErr : Boolean = false,
    var errMessage : String = "",
    var categories : List<CategoryApiModel> = listOf()
)
