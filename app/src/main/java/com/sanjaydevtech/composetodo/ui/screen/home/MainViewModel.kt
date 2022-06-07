package com.sanjaydevtech.composetodo.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sanjaydevtech.composetodo.generateToDos
import com.sanjaydevtech.composetodo.model.ToDo

class MainViewModel : ViewModel() {
    var toDoList by mutableStateOf(generateToDos())
        private set

    fun delete(id: Long) {
        toDoList = toDoList.filter { it.id != id }
    }

    fun add(toDo: ToDo) {
        toDoList = toDoList + toDo
    }
}