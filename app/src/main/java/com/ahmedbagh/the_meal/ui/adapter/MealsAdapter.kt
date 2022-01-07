package com.ahmedbagh.the_meal.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ahmedbagh.the_meal.R
import com.ahmedbagh.the_meal.data.model.MealApiModel

class MealsAdapter(
    private val meals: List<MealApiModel>,
    private val itemClick: (String) -> Unit
) : RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meal_item_layout, parent, false)

        return MealsAdapter.MealsViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) =
        holder.bind(meals[position])

    override fun getItemCount(): Int = meals.size

    class MealsViewHolder(
        itemView: View,
        private val itemClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(meal: MealApiModel) {
            val textView = itemView.findViewById<TextView>(R.id.meal_title_text)
            val imageView = itemView.findViewById<ImageView>(R.id.meal_thumb)

            Glide.with(itemView).load(meal.strMealThumb).into(imageView);
            textView.text = meal.strMeal
            itemView.setOnClickListener { itemClick(meal.idMeal) }
        }
    }
}