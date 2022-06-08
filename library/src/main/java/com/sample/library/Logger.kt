package com.sample.library

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Logger {
    private val loggerService = ServiceLocator.loggerService(BASE)
    private val scope = CoroutineScope(Dispatchers.IO)
    private lateinit var config: Config
    fun mint(config: Config) {
        this.config = config
    }

    fun log(level: Level, message: String) {
        if (!::config.isInitialized) return
        val logPayload = LogPayload(
            config.apiKey,
            config.projectId,
            level.level,
            message,
        )
        scope.launch {
            try {
                loggerService.postLog(
                    logPayload
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun event(key: String) {
        if (!::config.isInitialized) return
        val eventPayload = EventPayload(
            config.apiKey,
            config.projectId,
            key,
        )
        scope.launch {
            try {
                loggerService.postEvent(
                    eventPayload
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun t(message: String) = log(Level.TRACE, message)
    fun d(message: String) = log(Level.DEBUG, message)
    fun i(message: String) = log(Level.INFO, message)
    fun w(message: String) = log(Level.WARN, message)
    fun e(message: String) = log(Level.ERROR, message)
    fun f(message: String) = log(Level.FATAL, message)
    fun loginEvent() = event(Event.LOGIN.event)
    fun logoutEvent() = event(Event.LOGOUT.event)
}