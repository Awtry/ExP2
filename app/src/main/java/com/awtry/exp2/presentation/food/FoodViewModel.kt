package com.awtry.exp2.presentation.food

import androidx.lifecycle.ViewModel
import com.awtry.exp2.core.presentation.BaseViewModel
import com.awtry.exp2.domain.model.Food
import com.awtry.exp2.domain.usecase.GetFoodByCategory
import com.awtry.exp2.domain.usecase.GetFoodByName
import com.awtry.exp2.domain.usecase.SaveFood
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodViewModel @Inject constructor(
    private val getFoodByCategory: GetFoodByCategory,
    private val getFoodByName: GetFoodByName,
    private val saveFood: SaveFood
) : BaseViewModel() {

    fun doGetFoodByCategory(name: String){
        getFoodByCategory(name){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodReceived(it.meals ?: listOf())

                saveFood(it.meals ?: listOf())

                true
            }
        }
    }

    fun doGetFoodByName(name: String){
        getFoodByName(name){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodReceived(it.meals ?: listOf())

                saveFood(it.meals ?: listOf())

                true
            }
        }
    }

    private fun saveFood(meals: List<Food>){
        saveFood(meals){
            it.fold(::handleFailure){
                it
            }
        }
    }
}