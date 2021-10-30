package com.awtry.exp2.data.source

import com.awtry.exp2.core.plataform.NetworkHandler
import com.awtry.exp2.core.exception.Failure
import com.awtry.exp2.core.functional.Either
import com.awtry.exp2.data.api.FoodApi
import com.awtry.exp2.data.dao.FoodDAO
import com.awtry.exp2.data.dto.FoodResponse
import com.awtry.exp2.domain.model.Food
import com.awtry.exp2.domain.repository.FoodRepository
import com.awtry.exp2.framework.api.ApiRequest
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodApi: FoodApi,
    private val foodDAO: FoodDAO,
    private val networkHandler: NetworkHandler
): FoodRepository, ApiRequest {

    override fun getFoodByCategory(name: String): Either<Failure, FoodResponse> {
        val result = makeRequest(
            networkHandler,
            foodApi.getFoodByCategory(name),
            { it },
            FoodResponse(emptyList())
        )

        return if (result.isLeft) {

            val localResult = foodDAO.getFoodByCategory("%$name%")

            if (localResult.isEmpty()) result
            else Either.Right(FoodResponse(localResult))

        } else result
    }

    override fun getFoodByName(name: String): Either<Failure, FoodResponse> {
        val result = makeRequest(
            networkHandler,
            foodApi.getFoodByName(name),
            { it },
            FoodResponse(emptyList())
        )

        return if (result.isLeft) {

            val localResult = foodDAO.getFoodByName("%$name%")

            if (localResult.isEmpty()) result
            else Either.Right(FoodResponse(localResult))

        } else result
    }

    override fun saveFood(meals: List<Food>): Either<Failure, Boolean> {
        val result = foodDAO.onSaveFood(meals)
        return if (result.size == meals.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun updateFood(food: Food): Either<Failure, Boolean> {
        TODO("Not yet implemented")
    }

}