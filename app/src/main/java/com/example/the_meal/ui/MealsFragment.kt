package com.example.the_meal.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.the_meal.R
import com.example.the_meal.ui.adapter.MealsAdapter
import com.example.the_meal.ui.factory.MealsViewModelFactory
import com.example.the_meal.ui.viewmodel.viewmodel.MealsViewModel

class MealsFragment : Fragment(R.layout.meals_fragment) {

    lateinit var viewModel: MealsViewModel
    private val args: MealsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mealsRecyclerView = view.findViewById<RecyclerView>(R.id.meals_recyclerView)
        val mealsProgressBar = view.findViewById<ProgressBar>(R.id.meals_progressbar)
        val mealCategory = view.findViewById<TextView>(R.id.meal_category_str)
        mealCategory.text = args.strCategory

        mealsRecyclerView.layoutManager = LinearLayoutManager(context)

        val viewModelFactory = MealsViewModelFactory(args.strCategory)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MealsViewModel::class.java)

        viewModel.uiState.observe(this, Observer {
            mealsRecyclerView.adapter = MealsAdapter(it.meals) { idMeal ->
                val action = MealsFragmentDirections.actionMealsFragmentToMealDetailsFragment(idMeal)
                findNavController().navigate(action)
            }

            mealsRecyclerView.visibility = visibilityStatus(it.isLoading)
            mealsProgressBar.visibility = visibilityStatus(!it.isLoading)
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