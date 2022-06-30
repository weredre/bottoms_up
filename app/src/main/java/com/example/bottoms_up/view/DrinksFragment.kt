package com.example.bottoms_up.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottoms_up.adapter.CategoryDrinksAdapter
import com.example.bottoms_up.databinding.FragmentDrinksBinding
import com.example.bottoms_up.viewmodel.CategoryDrinksViewModel

class DrinksFragment : Fragment() {
    private var _binding: FragmentDrinksBinding? = null
    private val binding get() = _binding!!

    private val categoryDrinksViewModel by viewModels<CategoryDrinksViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDrinksBinding.inflate(
        inflater, container, false
    ).also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = arguments?.getString("category")

        binding.tvDrinks.text = category.toString()

        fun displayDrinks() =
            with(binding.rvList) {
                layoutManager =
                    LinearLayoutManager(this.context)
                adapter = CategoryDrinksAdapter().apply {
                    with(categoryDrinksViewModel) {
                        getDrinks(category!!)
                        stateList.observe(viewLifecycleOwner) {
                            addDrinks(it.drinks)
                        }
                    }
                }
            }
        displayDrinks()
    }
}