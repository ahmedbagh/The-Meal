package com.example.the_meal.ui.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.the_meal.data.repository.MealDetailsRepository
import com.example.the_meal.ui.viewmodel.uistate.MealDetailsUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class MealDetailsViewModel(
    private val mealDetailsRepository: MealDetailsRepository = MealDetailsRepository(),
    idMeal: String
) : ViewModel() {

    val uiState = MutableLiveData<MealDetailsUiState>()

    private var fetchJob: Job? = null

    init {
        fetchMealDetails(idMeal)
    }

    private fun fetchMealDetails(idMeal: String) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val mealDetails = mealDetailsRepository.fetchMealDetailsById(idMeal)
                uiState.value = MealDetailsUiState(isLoading = false, mealDetails = mealDetails)

            } catch (ioe: IOException) {
                val messages = ioe.message!!
                uiState.value =
                    MealDetailsUiState(isLoading = false, isErr = true, errMessage = messages)
            }
        }
    }
}