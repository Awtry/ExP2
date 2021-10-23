package com.awtry.exp2.data.source

import com.awtry.exp2.core.NetworkHandler
import com.awtry.exp2.core.exception.Failure
import com.awtry.exp2.core.functional.Either
import com.awtry.exp2.data.api.FoodCategoryApi
import com.awtry.exp2.data.dao.FoodCategoryDAO
import com.awtry.exp2.data.dto.FoodCategoryResponse
import com.awtry.exp2.domain.model.FoodCategory
import com.awtry.exp2.domain.repository.FoodCategoryRepository
import com.awtry.exp2.framework.api.ApiRequest
import javax.inject.Inject

class FoodCategoryRepositoryImpl @Inject constructor(
    private val foodCategoryApi: FoodCategoryApi,
    private val foodCategoryDAO: FoodCategoryDAO,
    private val networkHandler: NetworkHandler
) : FoodCategoryRepository, ApiRequest {
    override fun getFoodCategoryByName(name: String): Either<Failure, FoodCategoryResponse> {
        val result = makeRequest(
            networkHandler,
            foodCategoryApi.getFoodCategoryByName(name),
            { it },
            FoodCategoryResponse(emptyList())
        )

        return if (result.isLeft) {

            val localResult = foodCategoryDAO.getFoodCategoryByName("%$name%")

            if (localResult.isEmpty()) result
            else Either.Right(FoodCategoryResponse(localResult))

        } else result
    }

    override fun saveFoodCategory(foodCategories: List<FoodCategory>): Either<Failure, Boolean> {
        //TODO: Hay que revisar todos estos apartados en otra vuelta
        val result = foodCategoryDAO.onSaveFoodCategory(foodCategories)
        return if (result.size == foodCategories.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun updateFoodCategory(foodCategories: FoodCategory): Either<Failure, Boolean> {
        TODO("Not yet implemented")
    }

}