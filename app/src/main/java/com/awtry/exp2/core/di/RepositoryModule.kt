package com.awtry.exp2.core.di

import com.awtry.exp2.core.plataform.NetworkHandler
import com.awtry.exp2.data.api.FoodApi
import com.awtry.exp2.data.source.FoodRepositoryImpl
import com.awtry.exp2.domain.repository.FoodRepository
import com.awtry.exp2.framework.api.ApiProvider
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
}