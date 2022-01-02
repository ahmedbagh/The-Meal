package com.example.the_meal.data.datasource

import com.example.the_meal.data.api.MealService
import com.example.the_meal.data.model.CategoriesApiModel
import com.example.the_meal.data.model.Category
import com.example.the_meal.data.model.CategoryApiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.*

class CategoriesRemoteDataSource(
    private val mealService: MealService = MealService.create()
) {

    suspend fun fetchListOfCategories(): List<CategoryApiModel> =
        mealService.getAllCategories().listOfCategories
}