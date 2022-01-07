package com.example.the_meal.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.the_meal.R
import com.example.the_meal.ui.adapter.CategoriesAdapter
import com.example.the_meal.ui.viewmodel.viewmodel.CategoriesViewModel

class CategoriesFragment : Fragment(R.layout.categories_fragment) {

    lateinit var viewModel: CategoriesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesRecyclerView = view.findViewById<RecyclerView>(R.id.categories_recyclerView)
        val categoriesProgressBar = view.findViewById<ProgressBar>(R.id.categories_progressbar)

        categoriesRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)

        viewModel.uiState.observe(this, Observer {
            categoriesRecyclerView.adapter = CategoriesAdapter(it.categories) { strCategory ->
                val action = CategoriesFragmentDirections.actionCategoriesFragmentToMealsFragment(strCategory)

                findNavController().navigate(action)
            }

            categoriesRecyclerView.visibility = visibilityStatus(it.isLoading)
            categoriesProgressBar.visibility = visibilityStatus(!it.isLoading)
        })
    }

    private fun visibilityStatus(loading: Boolean): Int {
        return if (loading) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }


}