package com.awtry.exp2.data.dto

import com.awtry.exp2.domain.model.FoodCategory
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
//TODO: Camiar a donde esta apuntando
data class FoodCategoryResponse(val dishCategories: List<FoodCategory>? = listOf())
