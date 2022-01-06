package com.example.the_meal.ui.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.the_meal.R
import com.example.the_meal.data.model.CategoryApiModel

class CategoriesAdapter(
    private val categories: List<CategoryApiModel>,
    private val itemClick: (String) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item_layout, parent, false)

        return CategoriesViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) =
        holder.bind(categories[position])

    override fun getItemCount() = categories.size

    class CategoriesViewHolder(
        itemView: View,
        private val itemClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: CategoryApiModel) {
            val textView = itemView.findViewById<TextView>(R.id.title_text)
            val imageView = itemView.findViewById<ImageView>(R.id.category_thumb)

            Glide.with(itemView).load(category.strCategoryThumb).into(imageView);
            textView.text = category.strCategory
            itemView.setOnClickListener { itemClick(category.strCategory) }
        }
    }

}