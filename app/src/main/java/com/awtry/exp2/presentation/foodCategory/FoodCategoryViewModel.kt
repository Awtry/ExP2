package com.awtry.exp2.presentation.foodCategory

import com.awtry.exp2.core.interactor.UseCase
import com.awtry.exp2.core.presentation.BaseViewModel
import com.awtry.exp2.domain.model.FoodCategory
import com.awtry.exp2.domain.usecase.GetAllFoodCategories
import com.awtry.exp2.domain.usecase.SaveCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class FoodCategoryViewModel @Inject constructor(
    private val getAllFoodCategories: GetAllFoodCategories,
    private val saveCategory: SaveCategory
) : BaseViewModel() {

    fun doGetFoodCategories(){
        getAllFoodCategories(UseCase.None()){
            it.fold(::handleFailure){
                state.value = FoodCategoryViewState.FoodCategoryReceived(it.dishCategories ?: listOf())

               // saveFoodCategory(it.dishCategories ?: listOf())
                true
            }
        }
    }

    private fun saveFoodCategory(foodCategory: List<FoodCategory>){
        saveCategory(foodCategory){
            it.fold(::handleFailure){
                it
            }
        }
    }

}