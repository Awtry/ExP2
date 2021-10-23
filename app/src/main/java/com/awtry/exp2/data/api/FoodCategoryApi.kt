package com.awtry.exp2.data.api

import com.awtry.exp2.data.dto.FoodCategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodCategoryApi {

    //Link de referencia
    //www.themealdb.com/api/json/v1/1/categories.php

    @GET("json/v1/1/categories.php")
    fun getFoodCategoryByName(@Query("s") name: String): Call<FoodCategoryResponse>
    //@POST
    //@PUT
    //@DELETE
}