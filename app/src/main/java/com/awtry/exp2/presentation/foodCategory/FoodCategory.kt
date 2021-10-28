package com.awtry.exp2.presentation.foodCategory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.awtry.exp2.R
import com.awtry.exp2.core.extension.observe
import com.awtry.exp2.core.presentation.BaseFragment
import com.awtry.exp2.core.utils.LayoutType
import com.awtry.exp2.databinding.FoodCategoryFragmentBinding
import com.awtry.exp2.databinding.RowFoodBinding
import com.awtry.exp2.presentation.food.FoodAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class FoodCategory : BaseFragment(R.layout.food_category_fragment) {

    private lateinit var binding: FoodCategoryFragmentBinding

    private val adapter: FoodCategoryAdapter by lazy { FoodCategoryAdapter() }
    private val foodCategoryViewModel by viewModels<FoodCategoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodCategoryViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun setBinding(view: View) {
        TODO("Not yet implemented")
    }


}