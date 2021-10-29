package com.awtry.exp2.data.api

import com.awtry.exp2.data.dto.FoodCategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodCategoryApi {

    //Link de referencia
    //www.themealdb.com/api/json/v1/1/categories.php

    @GET("json/v1/1/categories.php")
    //Para traer todos los parametros, sin darle algo para buscar.
    fun getallFoodCategories(): Call<FoodCategoryResponse>
    //@POST
    //@PUT
    //@DELETE
}