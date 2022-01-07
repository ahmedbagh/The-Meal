package com.ahmedbagh.the_meal.ui.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmedbagh.the_meal.data.repository.MealsRepository
import com.ahmedbagh.the_meal.ui.viewmodel.uistate.MealsUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class MealsViewModel(
    private val mealsRepository: MealsRepository = MealsRepository(),
    private val strCategory: String
) : ViewModel() {

    val uiState = MutableLiveData<MealsUiState>()

    private var fetchJob: Job? = null

    init {
        fetchMeals()
    }

    private fun fetchMeals() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val meals = mealsRepository.fetchListOfAllMealsByCategory(strCategory)
                uiState.value = MealsUiState(meals = meals, isLoading = false)
            } catch (ioe: IOException) {
                val messages = ioe.message!!
                uiState.value = MealsUiState(isLoading = false, isErr = true, errMessage = messages)
            }

        }

    }
}