package com.ca1.onlineservice.services

import com.ca1.onlineservice.helpers.Config
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceBuilder {
    // Create okhttp client
    private val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()

    // Create retrofit builder
    private val builder: Retrofit.Builder =
        Retrofit.Builder().baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())

    // Create retrofit instance
    private val retrofit: Retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}