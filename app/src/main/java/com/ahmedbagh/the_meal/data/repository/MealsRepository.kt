package com.ahmedbagh.the_meal.data.repository

import com.ahmedbagh.the_meal.data.datasource.MealsRemoteDataSource
import com.ahmedbagh.the_meal.data.model.MealApiModel

class MealsRepository(
    private val mealsRemoteDataSource: MealsRemoteDataSource = MealsRemoteDataSource()
) {
    suspend fun fetchListOfAllMealsByCategory(strCategory: String): List<MealApiModel> =
        mealsRemoteDataSource.fetchListOfMeals(strCategory)
}