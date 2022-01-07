package com.example.the_meal.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.the_meal.R
import com.example.the_meal.ui.factory.MealDetailsViewModelFactory
import com.example.the_meal.ui.viewmodel.viewmodel.MealDetailsViewModel

class MealDetailsFragment : Fragment(R.layout.meal_details_fragment) {

    private val args: MealDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: MealDetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mealDetailsTitle = view.findViewById<TextView>(R.id.meal_details_title)
        val mealDetailsThumb = view.findViewById<ImageView>(R.id.meal_details_thumb)
        val mealDetailsArea = view.findViewById<TextView>(R.id.meal_details_area_str)
        val mealDetailsCategory = view.findViewById<TextView>(R.id.meal_details_category_str)
        val mealDetailsInstruction = view.findViewById<TextView>(R.id.meal_details_instructions)

        val viewModelFactory = MealDetailsViewModelFactory(args.idMeal)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MealDetailsViewModel::class.java)

        viewModel.uiState.observe(this, Observer {
            with(it.mealDetails) {
                mealDetailsTitle.text = strMeal
                Glide.with(view).load(strMealThumb).into(mealDetailsThumb);
                mealDetailsArea.text = strArea
                mealDetailsCategory.text = strCategory
                mealDetailsInstruction.text = strInstructions
            }

        })
    }
}