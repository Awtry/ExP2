package com.awtry.exp2.presentation.foodCategory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awtry.exp2.R

class FoodCategory : Fragment() {

    companion object {
        fun newInstance() = FoodCategory()
    }

    private lateinit var viewModel: FoodCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.food_category_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FoodCategoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}