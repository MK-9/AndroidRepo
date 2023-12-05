package ir.divar.androidtask.data.network

import okhttp3.Interceptor
import okhttp3.Response

class MyServiceInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("x-access-token", ACCESS_TOKEN)
            .build()

        return chain.proceed(request)
    }

    companion object {
        const val ACCESS_TOKEN =
            "Basic YXBpa2V5OjY5Y1dxVW8wNGhpNFdMdUdBT2IzMmRXZXQjsllsVzBtSkNiwU9yLUxEamNDUXFMSzJnR29mS3plZg=="
    }
}