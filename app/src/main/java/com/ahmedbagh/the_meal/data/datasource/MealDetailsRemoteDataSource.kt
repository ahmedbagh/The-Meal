package com.ahmedbagh.the_meal.data.datasource

import com.ahmedbagh.the_meal.data.api.MealService
import com.ahmedbagh.the_meal.data.model.MealDetails

class MealDetailsRemoteDataSource(
    private val mealService: MealService = MealService.create()
) {
    suspend fun fetchMealDetailsById(idMeal: String): MealDetails =
        mealService.getMealDetailsByIdMeal(idMeal).meals[0]
}