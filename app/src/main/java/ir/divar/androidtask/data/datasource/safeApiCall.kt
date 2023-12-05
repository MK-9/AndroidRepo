package ir.divar.androidtask.data.datasource

import ir.divar.androidtask.data.network.models.Result
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

internal suspend fun <T : Any> safeApiCall(input: suspend () -> Response<T>): Result<T> {
    try {
        val response = input.invoke()

        if (response.isSuccessful) {
            response.body()?.run {
                return Result.OnSuccess(this)
            }
        }

        return Result.OnError(response.message())

    } catch (e: Exception) {
        return when (e) {
            is HttpException -> {
                Result.OnError("HttpException")
            }

            is IOException -> {
                Result.OnError("IOException")
            }

            else -> Result.OnError("error")
        }
    }
}