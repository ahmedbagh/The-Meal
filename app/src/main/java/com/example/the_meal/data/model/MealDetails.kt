package com.example.the_meal.data.model

/**
 * Data class that represents a meal details.
 *
 * Not all of the fields returned from the API are represented here; only the ones used in this
 * project are listed below. For a full list of fields, consult the API documentation
 * [here](https://www.themealdb.com/api.php).
 */
data class MealDetails(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
)
