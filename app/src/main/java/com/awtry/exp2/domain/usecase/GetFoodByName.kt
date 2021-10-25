package com.awtry.exp2.domain.usecase

import com.awtry.exp2.core.interactor.UseCase
import com.awtry.exp2.data.dto.FoodResponse
import com.awtry.exp2.domain.repository.FoodRepository
import javax.inject.Inject

class GetFoodByName @Inject constructor(private val foodRepository: FoodRepository) :
    UseCase<FoodResponse, String>(){

    override suspend fun run(params: String) = foodRepository.getFoodByName(params)

}