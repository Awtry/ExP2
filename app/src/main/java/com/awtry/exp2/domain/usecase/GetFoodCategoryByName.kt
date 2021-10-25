package com.awtry.exp2.domain.usecase

import com.awtry.exp2.core.interactor.UseCase
import com.awtry.exp2.data.dto.FoodCategoryResponse
import com.awtry.exp2.domain.repository.FoodCategoryRepository
import javax.inject.Inject

class GetFoodCategoryByName @Inject constructor(private val foodCategoryRepository: FoodCategoryRepository) :
UseCase<FoodCategoryResponse, String>()
{
    //Busca el nombre dado directgamente con los parametros
    override suspend fun run(params: String) = foodCategoryRepository.getFoodCategoryByName(params)
}