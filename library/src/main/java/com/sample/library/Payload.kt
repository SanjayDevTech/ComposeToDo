package com.sample.library

data class LogPayload(
    val apiKey: String,
    val projectId: String,
    val type: String,
    val message: String,
)

data class EventPayload(
    val apiKey: String,
    val projectId: String,
    val key: String,
)