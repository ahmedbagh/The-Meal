package com.example.the_meal.data.model

import com.google.gson.annotations.SerializedName

data class CategoriesApiModel(
    @SerializedName("categories") val listOfCategories : List<CategoryApiModel>
)
