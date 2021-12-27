package com.example.the_meal.api

import com.example.the_meal.data.CategoryApiModel
import com.example.the_meal.data.MealApiModel
import com.example.the_meal.data.MealDetails
import com.example.the_meal.data.MealDetailsApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Used to connect to the The MealDB API to fetch photos
 */
interface MealService {

    @GET("categories.php")
    suspend fun getAllCategories(): List<CategoryApiModel>

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") strCategory: String
    ): List<MealApiModel>

    @GET("lookup.php")
    suspend fun getMealDetailsByIdMeal(
        @Query("i") idMeal : String
    ) : List<MealDetailsApiModel>

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