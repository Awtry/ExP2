package com.awtry.exp2.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
//TODO: Camiar a donde esta apuntando
data class FoodResponse(val dishes: List<P2Elemento>? = listOf())
