package com.awtry.exp2.data.api


import com.awtry.exp2.data.dto.FoodResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    //Link de referencia
    //www.themealdb.com/api/json/v1/1/search.php?s=

    @GET("json/v1/1/search.php")
    fun getFoodByName(@Query("s") name: String): Call<FoodResponse>
    //@POST
    //@PUT
    //@DELETE
}