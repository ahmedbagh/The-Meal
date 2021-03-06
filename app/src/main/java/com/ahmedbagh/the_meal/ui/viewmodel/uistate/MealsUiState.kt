package com.ahmedbagh.the_meal.ui.viewmodel.uistate

import com.ahmedbagh.the_meal.data.model.MealApiModel

data class MealsUiState(
    val isLoading : Boolean = true,
    val isErr : Boolean = false,
    var errMessage : String = "",
    var meals : List<MealApiModel> = listOf()
)