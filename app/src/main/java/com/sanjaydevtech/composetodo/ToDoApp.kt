package com.sanjaydevtech.composetodo

import android.app.Application
import com.sample.library.Logger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ToDoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalScope.launch {
            val config = applicationContext.getConfig()
            Logger.mint(config)
        }
    }
}