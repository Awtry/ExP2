package com.awtry.exp2.domain.usecase

import com.awtry.exp2.core.interactor.UseCase
import com.awtry.exp2.domain.model.FoodCategory
import com.awtry.exp2.domain.repository.FoodCategoryRepository
import javax.inject.Inject

class SaveCategory @Inject constructor(private val foodCategoryRepository: FoodCategoryRepository) :
    UseCase<Boolean, List<FoodCategory>>() {

    override suspend fun run(params: List<FoodCategory>) =
        foodCategoryRepository.saveFoodCategory(params)
}