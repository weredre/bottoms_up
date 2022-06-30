package com.example.bottoms_up.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottoms_up.databinding.ItemDrinksBinding
import com.example.bottoms_up.model.response.DrinkDetailsDTO
import com.squareup.picasso.Picasso

class CategoryDrinksAdapter : RecyclerView.Adapter<CategoryDrinksAdapter.CategoryDrinksViewHolder>() {
    private var drinks = listOf<DrinkDetailsDTO.Drink>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDrinksViewHolder {
        return CategoryDrinksViewHolder.getInstance(parent)
    }

    override fun onBindViewHolder(holder: CategoryDrinksViewHolder, position: Int) {
        holder.bindDrink(drinks[position])
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    fun addDrinks(drinks: List<DrinkDetailsDTO.Drink>) {
        this.drinks = drinks
        notifyDataSetChanged()
    }

    class CategoryDrinksViewHolder(
        private val binding: ItemDrinksBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindDrink(drink: DrinkDetailsDTO.Drink) = with(binding) {
            tvDrinks.text = drink.strDrink
            Picasso.get().load(drink.strDrinkThumb).into(ivDrink);
        }

        companion object {
            fun getInstance(parent: ViewGroup) = ItemDrinksBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).let { CategoryDrinksViewHolder(it) }
        }
    }
}
