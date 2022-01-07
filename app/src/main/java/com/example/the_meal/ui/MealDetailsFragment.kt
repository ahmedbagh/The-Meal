package com.example.the_meal.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.the_meal.R
import com.example.the_meal.databinding.MealDetailsFragmentBinding
import com.example.the_meal.ui.factory.MealDetailsViewModelFactory
import com.example.the_meal.ui.viewmodel.viewmodel.MealDetailsViewModel

class MealDetailsFragment : Fragment(R.layout.meal_details_fragment) {

    private val args: MealDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: MealDetailsViewModel
    private lateinit var binding : MealDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModelFactory = MealDetailsViewModelFactory(args.idMeal)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MealDetailsViewModel::class.java)

        viewModel.uiState.observe(this, Observer {
            binding.mealDetails = it.mealDetails
            Glide.with(view!!).load(it.mealDetails.strMealThumb).into(binding.mealDetailsThumb);
        })

        binding = MealDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}