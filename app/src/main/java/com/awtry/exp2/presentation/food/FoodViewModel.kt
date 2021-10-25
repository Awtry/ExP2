package com.awtry.exp2.presentation.food

import androidx.lifecycle.ViewModel
import com.awtry.exp2.core.presentation.BaseViewModel
import com.awtry.exp2.domain.model.Food
import com.awtry.exp2.domain.usecase.GetFoodByName
import com.awtry.exp2.domain.usecase.SaveFood
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodViewModel @Inject constructor(
    private val getFoodByName: GetFoodByName,
    private val saveFood: SaveFood
) : BaseViewModel() {

    fun doGetFoodByName(name: String){
        getFoodByName(name){
            it.fold(::handleFailure){
                state.value = FoodViewState.FoodReceived(it.dishses ?: listOf())

                saveFood(it.dishses ?: listOf())

                true
            }
        }
    }

    private fun saveFood(foods: List<Food>){
        saveFood(foods){
            it.fold(::handleFailure){
                it
            }
        }
    }
}