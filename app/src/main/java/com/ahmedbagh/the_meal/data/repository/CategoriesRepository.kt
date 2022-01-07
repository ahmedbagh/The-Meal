package com.ahmedbagh.the_meal.data.repository

import com.ahmedbagh.the_meal.data.datasource.CategoriesRemoteDataSource
import com.ahmedbagh.the_meal.data.model.CategoryApiModel

class CategoriesRepository(
    private val categoriesRemoteDataSource: CategoriesRemoteDataSource = CategoriesRemoteDataSource()
) {
    suspend fun fetchListOfAllCategories(): List<CategoryApiModel> =
        categoriesRemoteDataSource.fetchListOfCategories()
}