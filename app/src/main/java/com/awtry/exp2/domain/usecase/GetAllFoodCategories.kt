package com.awtry.exp2.domain.usecase

import com.awtry.exp2.core.exception.Failure
import com.awtry.exp2.core.functional.Either
import com.awtry.exp2.core.interactor.UseCase
import com.awtry.exp2.data.dto.FoodCategoryResponse
import com.awtry.exp2.domain.repository.FoodCategoryRepository
import javax.inject.Inject

class GetAllFoodCategories @Inject constructor(private val foodCategoryRepository: FoodCategoryRepository) :
UseCase<FoodCategoryResponse, UseCase.None>()
{
    //Busca el nombre dado directgamente con los parametros
    override suspend fun run(params: None) = foodCategoryRepository.getAllFoodCategories()

}