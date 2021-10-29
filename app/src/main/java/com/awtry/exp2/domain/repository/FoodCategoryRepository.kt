package com.awtry.exp2.domain.repository

import com.awtry.exp2.core.exception.Failure
import com.awtry.exp2.core.functional.Either
import com.awtry.exp2.data.dto.FoodCategoryResponse
import com.awtry.exp2.domain.model.FoodCategory

interface FoodCategoryRepository {

    fun getAllFoodCategories(): Either<Failure, FoodCategoryResponse>

    fun saveFoodCategory(foodCategories: List<FoodCategory>): Either<Failure, Boolean>

    fun updateFoodCategory(foodCategories: FoodCategory): Either<Failure, Boolean>
}