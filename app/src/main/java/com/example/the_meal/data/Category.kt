package com.example.the_meal.data

/**
 * Data class that represents a category.
 *
 * Not all of the fields returned from the API are represented here; only the ones used in this
 * project are listed below. For a full list of fields, consult the API documentation
 * [here](https://www.themealdb.com/api.php).
 */
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
)
