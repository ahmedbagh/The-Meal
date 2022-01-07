package com.ahmedbagh.the_meal.data.repository

import com.ahmedbagh.the_meal.data.datasource.MealDetailsRemoteDataSource
import com.ahmedbagh.the_meal.data.model.MealDetails

class MealDetailsRepository(
    private val mealDetailsRemoteDataSource: MealDetailsRemoteDataSource = MealDetailsRemoteDataSource()
) {
    suspend fun fetchMealDetailsById(idMeal: String): MealDetails =
        mealDetailsRemoteDataSource.fetchMealDetailsById(idMeal)
}