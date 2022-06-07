package com.sanjaydevtech.composetodo.model

data class ToDo(
    val id: Long,
    val title: String,
    val content: String,
    val created: Long,
    val updated: Long? = null,
    val due: Long? = null,
)