package com.awtry.exp2.presentation.foodCategory

import com.awtry.exp2.core.presentation.BaseViewState
import com.awtry.exp2.domain.model.FoodCategory

sealed class FoodCategoryViewState : BaseViewState() {
    data class FoodCategoryReceived(val foodCategories: List<FoodCategory>) : BaseViewState()
}