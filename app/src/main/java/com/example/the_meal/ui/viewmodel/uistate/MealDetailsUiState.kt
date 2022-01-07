package com.example.the_meal.ui.viewmodel.uistate

import com.example.the_meal.data.model.CategoryApiModel
import com.example.the_meal.data.model.MealDetails

data class MealDetailsUiState(
    val isLoading : Boolean = true,
    val isErr : Boolean = false,
    var errMessage : String = "",
    var mealDetails : MealDetails = MealDetails()
)