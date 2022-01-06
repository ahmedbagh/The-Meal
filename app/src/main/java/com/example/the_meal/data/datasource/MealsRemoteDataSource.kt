package com.example.the_meal.data.datasource

import com.example.the_meal.data.api.MealService
import com.example.the_meal.data.model.MealApiModel

class MealsRemoteDataSource(
    private val mealService: MealService = MealService.create()
) {
    suspend fun fetchListOfMeals(strCategory: String): List<MealApiModel> =
        mealService.getMealsByCategory(strCategory).listOfMeals
}