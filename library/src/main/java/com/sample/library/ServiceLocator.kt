package com.sample.library

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object ServiceLocator {
    fun loggerService(url: String): LoggerService {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoggerService::class.java)
    }
}