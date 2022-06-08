package com.sanjaydevtech.composetodo

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.sample.library.Config
import com.sanjaydevtech.composetodo.model.ToDo
import kotlinx.coroutines.flow.first
import java.time.LocalDate

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

val API_KEY = stringPreferencesKey("apiKey")
val PROJECT_ID = stringPreferencesKey("projectId")

suspend fun Context.getConfig(): Config {
    val prefs = dataStore.data.first()
    return Config(
        apiKey = prefs[API_KEY] ?: "",
        projectId = prefs[PROJECT_ID] ?: "",
    )
}

suspend fun Context.setConfig(config: Config) {
    dataStore.updateData {
        val preferences = it.toMutablePreferences()
        preferences[API_KEY] = config.apiKey
        preferences[PROJECT_ID] = config.projectId
        preferences
    }
}

@SuppressLint("NewApi")
fun generateToDos(): List<ToDo> {
    return listOf<ToDo>(
        ToDo(
            id = 1,
            title = "Demo",
            content = "Demo1 content\nhello\nhello",
            created = LocalDate.parse("2021-12-12").toEpochDay()
        ),
        ToDo(
            id = 2,
            title = "Demo",
            content = "Demo1 contentellooooooooooooooooooooooooooooooooooooooooo\nhelooooooooooooooo dfhgf hjdjfh   djhfhjdfhjdfjfh\nsdhsdghdsg",
            created = LocalDate.parse("2021-12-12").toEpochDay()
        )
    )
}