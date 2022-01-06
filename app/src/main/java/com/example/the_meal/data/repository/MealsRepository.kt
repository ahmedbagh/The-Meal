package com.example.the_meal.data.repository

import com.example.the_meal.data.datasource.MealsRemoteDataSource
import com.example.the_meal.data.model.MealApiModel

class MealsRepository(
    private val mealsRemoteDataSource: MealsRemoteDataSource = MealsRemoteDataSource()
) {
    suspend fun fetchListOfAllMealsByCategory(strCategory: String): List<MealApiModel> =
        mealsRemoteDataSource.fetchListOfMeals(strCategory)
}