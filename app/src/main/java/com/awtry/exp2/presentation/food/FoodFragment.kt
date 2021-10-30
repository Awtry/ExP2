package com.awtry.exp2.presentation.food

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.awtry.exp2.R
import com.awtry.exp2.core.extension.failure
import com.awtry.exp2.core.extension.observe
import com.awtry.exp2.core.presentation.BaseFragment
import com.awtry.exp2.core.presentation.BaseViewState
import com.awtry.exp2.core.utils.LayoutType
import com.awtry.exp2.databinding.FoodFragmentBinding
import com.awtry.exp2.domain.model.Food
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class FoodFragment : BaseFragment(R.layout.food_fragment) {

    private lateinit var binding: FoodFragmentBinding
    private val args: FoodFragmentArgs by navArgs()
    private val adapter: FoodAdapter by lazy { FoodAdapter() }
    private val foodViewModel by viewModels<FoodViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            //Agarrar los parametos duramente
            doGetFoodByCategory(args.food)
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is FoodViewState.FoodReceived -> setUpAdapter(state.foods)
        }
    }

    private fun setUpAdapter(foods: List<Food>) {

        //TODO: ¿Agregar lo de pantalla vacía?

        adapter.addData(foods)

        //TODO: Agregar el detalle del platillo
        adapter.listener = {
         //   navController.navigate()
        }

        binding.reciclador.apply {
            isVisible = foods.isNotEmpty()
            adapter = this@FoodFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = FoodFragmentBinding.bind(view)
        binding.lifecycleOwner = this

        binding.searchBarFood.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                foodViewModel.doGetFoodByName(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                foodViewModel.doGetFoodByName(newText ?: "")
                return true
            }

        })

        binding.SwipRefresh.setOnClickListener {
            //TODO: Reparar esta zona
            val newLayout = if (adapter.layoutType == LayoutType.LINEAR) {
                binding.reciclador.layoutManager = LinearLayoutManager(requireContext())
                LayoutType.LINEAR
            } else {
                binding.reciclador.layoutManager = LinearLayoutManager(requireContext())
                LayoutType.LINEAR
            }

            adapter.changeView(newLayout)
        }

        //Algo

        binding.apply {
            lifecycleOwner = this@FoodFragment
            food = args.food
        }
    }


}