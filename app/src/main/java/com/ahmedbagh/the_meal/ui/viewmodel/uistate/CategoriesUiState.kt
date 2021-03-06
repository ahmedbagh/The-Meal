package com.ahmedbagh.the_meal.ui.viewmodel.uistate

import com.ahmedbagh.the_meal.data.model.CategoryApiModel

data class CategoriesUiState(
    val isLoading : Boolean = true,
    val isErr : Boolean = false,
    var errMessage : String = "",
    var categories : List<CategoryApiModel> = listOf()
)
