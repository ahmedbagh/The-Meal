package com.ahmedbagh.the_meal.data.api

import com.ahmedbagh.the_meal.data.model.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Connects to the The MealDB API
 */
interface MealService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoriesApiModel

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") strCategory: String
    ): MealsApiModel

    @GET("lookup.php")
    suspend fun getMealDetailsByIdMeal(
        @Query("i") idMeal : String
    ) : MealDetailsApiModel

    companion object {
        var BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

        fun create(): MealService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(MealService::class.java)

        }
    }

}