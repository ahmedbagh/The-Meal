package com.example.the_meal.data.datasource

import com.example.the_meal.data.api.MealService
import com.example.the_meal.data.model.CategoryApiModel

class CategoriesRemoteDataSource(
    private val mealService: MealService = MealService.create()
) {

    suspend fun fetchListOfCategories(): List<CategoryApiModel> =
        mealService.getAllCategories().listOfCategories
}