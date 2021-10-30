package com.awtry.exp2.core.di

import com.awtry.exp2.core.plataform.NetworkHandler
import com.awtry.exp2.data.api.FoodApi
import com.awtry.exp2.data.api.FoodCategoryApi
import com.awtry.exp2.data.source.FoodCategoryRepositoryImpl
import com.awtry.exp2.data.source.FoodRepositoryImpl
import com.awtry.exp2.domain.repository.FoodCategoryRepository
import com.awtry.exp2.domain.repository.FoodRepository
import com.awtry.exp2.framework.api.ApiProvider
import com.awtry.exp2.framework.db.FoodCategoryDB
import com.awtry.exp2.framework.db.FoodDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providerFoodRepository(
        apiProvider: ApiProvider,
        foodDB: FoodDB,
        networkHandler: NetworkHandler
    ): FoodRepository =
        FoodRepositoryImpl(
            apiProvider.getEndpoint(FoodApi::class.java),
            networkHandler = networkHandler,
            foodDAO = foodDB.FoodDAO()
        )

    @Provides
    @Singleton
    fun providerFoodCategoryRepository(
        apiProvider: ApiProvider,
        foodCategoryDB: FoodCategoryDB,
        networkHandler: NetworkHandler
    ): FoodCategoryRepository =
        FoodCategoryRepositoryImpl(
            apiProvider.getEndpoint(FoodCategoryApi::class.java),
            networkHandler = networkHandler,
            foodCategoryDAO = foodCategoryDB.FoodCategoryDAO()
        )

}