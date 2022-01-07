package com.ahmedbagh.the_meal.data.model

import com.google.gson.annotations.SerializedName

data class MealsApiModel(
    @SerializedName("meals") val listOfMeals: List<MealApiModel>
)
