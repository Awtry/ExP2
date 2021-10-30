package com.awtry.exp2.presentation.foodCategory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.awtry.exp2.R
import com.awtry.exp2.core.extension.failure
import com.awtry.exp2.core.extension.observe
import com.awtry.exp2.core.presentation.BaseFragment
import com.awtry.exp2.core.presentation.BaseViewState
import com.awtry.exp2.core.utils.LayoutType
import com.awtry.exp2.databinding.FoodCategoryFragmentBinding
import com.awtry.exp2.databinding.RowFoodBinding
import com.awtry.exp2.domain.model.FoodCategory
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

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is FoodCategoryViewState.FoodCategoryReceived -> setUpAdapter(state.categories)
        }
    }

    private fun setUpAdapter(categories: List<FoodCategory>) {

       // binding.initialView.isVisible = categories.isEmpty()
        //TODO: Pantalla vacía
        adapter.addDataCategory(categories)

        //TODO: Detalle ?
        adapter.listener = {
            navController.navigate(FoodCategoryDirections.actionFoodCategoryToFoodFragment2(it.nameCategory))
        }

        //TODO: Reciclador
        binding.recicladorCategory.apply {
            isVisible = categories.isNotEmpty()
            adapter = this@FoodCategory.adapter
        }

    }

    override fun setBinding(view: View) {
        binding = FoodCategoryFragmentBinding.bind(view)
        binding.lifecycleOwner = this

        foodCategoryViewModel.doGetFoodCategories()

        binding.swipCateRefresh.setOnClickListener {
            //TODO: Realmente encontrar la forma de solo salzar uno
        }


        val newLayout = if (adapter.layoutType == LayoutType.GRID) {
            binding.recicladorCategory.layoutManager = GridLayoutManager(requireContext(),3)
            LayoutType.GRID
        } else {
            binding.recicladorCategory.layoutManager = GridLayoutManager(requireContext(), 3)
            LayoutType.GRID
        }

        adapter.changeView(newLayout)
    }




}