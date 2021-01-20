package com.android.retrofit3.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {
    var base_URL="https://jsonplaceholder.typicode.com"

    private val logger = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }
    val okHttp=OkHttpClient.Builder()
        .addInterceptor(logger)
        .callTimeout(5, TimeUnit.SECONDS)

    var builder=Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(base_URL).client(okHttp.build())


    private val retrofit= builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}