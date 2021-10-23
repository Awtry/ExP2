package com.awtry.exp2.framework.api

import com.awtry.exp2.core.NetworkHandler
import com.awtry.exp2.core.exception.Failure
import com.awtry.exp2.core.functional.Either
import retrofit2.Call
import java.lang.Exception

interface ApiRequest {

    //Solo para asegurarnos de que realmente se haga la conexión
    //De lo contrario que mande un mensaje
    fun <T, R> makeRequest(
        networkHandler: NetworkHandler,
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<Failure, R> {
        return when(networkHandler.isConnected) {
            true -> {
                try {
                    val response = call.execute()
                    when (response.isSuccessful) {
                        true -> Either.Right(transform(response.body() ?: default))
                        false -> Either.Left(Failure.ServerError(500, ""))
                    }
                } catch (e: Exception) {
                    Either.Left(Failure.ServerError(500, e.message))
                }
            }
            false -> Either.Left(Failure.NetworkConnection)
        }
    }
}