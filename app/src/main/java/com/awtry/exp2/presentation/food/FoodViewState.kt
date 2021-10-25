package com.awtry.exp2.presentation.food

import com.awtry.exp2.core.presentation.BaseViewState
import com.awtry.exp2.domain.model.Food

sealed class FoodViewState : BaseViewState() {
    data class FoodReceived(val foods: List<Food>) : BaseViewState()
}
