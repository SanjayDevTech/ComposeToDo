package com.sample.library

const val BASE = "https://logglytics.herokuapp.com"

enum class Level(val level: String) {
    TRACE("TRACE"),
    DEBUG("DEBUG"),
    INFO("INFO"),
    WARN("WARN"),
    ERROR("ERROR"),
    FATAL("FATAL"),
}

enum class Event(val event: String) {
    LOGIN("LOGIN"),
    LOGOUT("LOGOUT"),
}