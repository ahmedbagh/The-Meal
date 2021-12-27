package com.example.the_meal.data

data class MealDetailsApiModel(
    val idMeal: String,
    val strMeal: String,
    val strDrinkAlternate : String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strCategory: String,
    val strTags : String,
    val strSource: String,
    val strImageSource: String,
    val strCreativeCommonsConfirmed : String,
    val dateModified : String
)
