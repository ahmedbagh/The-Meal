package com.example.the_meal.ui.viewmodel

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.the_meal.R
import com.example.the_meal.ui.adapter.CategoriesAdapter
import com.example.the_meal.ui.viewmodel.viewmodel.CategoriesViewModel

class CategoriesFragment : AppCompatActivity() {

    private val TAG = "MyActivity"

    lateinit var viewModel: CategoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories_fragment)

        val categoriesRecyclerView = findViewById<RecyclerView>(R.id.categories_recyclerView)
        val categoriesProgressBar = findViewById<ProgressBar>(R.id.categories_progressbar)

        categoriesRecyclerView.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)

        viewModel.uiState.observe(this, Observer {
            Log.d(TAG, "onCreate: ${it.isLoading}")
            categoriesRecyclerView.adapter = CategoriesAdapter(it.categories)

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