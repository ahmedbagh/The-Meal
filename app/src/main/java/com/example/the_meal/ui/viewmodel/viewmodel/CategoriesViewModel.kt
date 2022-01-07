package com.example.the_meal.ui.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.the_meal.data.repository.CategoriesRepository
import com.example.the_meal.ui.viewmodel.uistate.CategoriesUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class CategoriesViewModel(
    private val categoriesRepository: CategoriesRepository = CategoriesRepository()
) : ViewModel() {

    val uiState = MutableLiveData<CategoriesUiState>()

    private var fetchJob: Job? = null

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val categories = categoriesRepository.fetchListOfAllCategories()
                uiState.value = CategoriesUiState(categories = categories, isLoading = false)
            } catch (ioe: IOException) {
                val messages = ioe.message!!
                uiState.value = CategoriesUiState(isLoading = false, isErr = true, errMessage = messages)
            }

        }

    }
}