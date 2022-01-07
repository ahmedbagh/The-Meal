package com.example.the_meal.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.the_meal.ui.viewmodel.viewmodel.MealDetailsViewModel

class MealDetailsViewModelFactory(
    private val idMeal: String
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealDetailsViewModel::class.java)) {
            return MealDetailsViewModel(idMeal = idMeal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
