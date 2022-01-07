package com.ahmedbagh.the_meal.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahmedbagh.the_meal.ui.viewmodel.viewmodel.MealsViewModel

class MealsViewModelFactory(
    private val strCategory: String
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealsViewModel::class.java)) {
            return MealsViewModel(strCategory = strCategory) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
