package com.example.bottoms_up.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bottoms_up.databinding.ItemCategoriesBinding
import com.example.bottoms_up.model.response.CategoryDTO
import com.example.bottoms_up.view.CategoryFragmentDirections

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var categories = listOf<CategoryDTO.CategoryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.getInstance(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindCategory(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun addCategories(categories: CategoryDTO) {
        this.categories = categories.categoryItems
        notifyDataSetChanged()
    }

    class CategoryViewHolder(
        private val binding: ItemCategoriesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindCategory(category: CategoryDTO.CategoryItem) = with(binding) {
            tvCategory.text = category.strCategory
            binding.tvCategory.setOnClickListener {
                it.findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToDrinksFragment(category.strCategory))
            }
        }

        companion object {
            fun getInstance(parent: ViewGroup) = ItemCategoriesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).let { CategoryViewHolder(it) }
        }
    }
}