package com.sanjaydevtech.composetodo

import android.annotation.SuppressLint
import com.sanjaydevtech.composetodo.model.ToDo
import java.time.LocalDate

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