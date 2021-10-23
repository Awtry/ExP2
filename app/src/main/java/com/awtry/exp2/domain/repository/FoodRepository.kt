package com.awtry.exp2.domain.repository

import com.awtry.exp2.core.exception.Failure
import com.awtry.exp2.core.functional.Either
import com.awtry.exp2.data.dto.FoodResponse
import com.awtry.exp2.domain.model.Food

interface FoodRepository {

    fun getFoodByName(name: String): Either<Failure, FoodResponse>

    fun saveFood(food: List<Food>): Either<Failure, Boolean>

    fun updateFood(food: Food): Either<Failure, Boolean>

}