package com.awtry.exp2.data.dto

import com.awtry.exp2.domain.model.Food
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FoodResponse(val dishses: List<Food>? = listOf())
