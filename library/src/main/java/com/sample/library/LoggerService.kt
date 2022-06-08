package com.sample.library

import retrofit2.http.Body
import retrofit2.http.POST

internal interface LoggerService {
    @POST("/api/log")
    suspend fun postLog(@Body logPayload: LogPayload): Response

    @POST("/api/event")
    suspend fun postEvent(@Body eventPayload: EventPayload): Response
}