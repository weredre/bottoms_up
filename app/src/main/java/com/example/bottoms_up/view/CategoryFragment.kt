package com.example.bottoms_up.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottoms_up.adapter.CategoryAdapter
import com.example.bottoms_up.databinding.FragmentCategoryBinding
import com.example.bottoms_up.viewmodel.CategoryViewModel


class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private val categoryViewModel by viewModels<CategoryViewModel>()
    private val categoryAdapter by lazy { CategoryAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCategoryBinding.inflate(
        inflater, container, false
    ).also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun displayCategories() =
            with(binding.rvList) {
                layoutManager =
                    LinearLayoutManager(this.context)
                adapter = CategoryAdapter().apply {
                    with(categoryViewModel) {
                        getCategories()
                        stringList.observe(viewLifecycleOwner) {
                            addCategories(it)
                        }
                    }
                }
            }
        displayCategories()
    }

}