package com.awtry.exp2.domain.usecase

import com.awtry.exp2.core.interactor.UseCase
import com.awtry.exp2.domain.model.Food
import com.awtry.exp2.domain.repository.FoodRepository
import javax.inject.Inject

class SaveFood @Inject constructor(private val foodRepository: FoodRepository) :
    UseCase<Boolean, List<Food>>() {

    override suspend fun run(params: List<Food>) = foodRepository.saveFood(params)

}