package com.awtry.exp2.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Ex2Api {

    //Link de referencia
    //https://www.themealdb.com/api/json/v1/1/search.php?f=a

    @GET("json/v1/1/search.php")
    fun getFoodByName(@Query("s") name: String): Call<P2ElementoResponse>
    //@POST
    //@PUT
    //@DELETE
}