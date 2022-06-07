package com.sanjaydevtech.composetodo.ui.screen.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sanjaydevtech.composetodo.model.ToDo
import com.sanjaydevtech.composetodo.ui.component.ActionBar
import com.sanjaydevtech.composetodo.ui.component.ToDoItem
import com.sanjaydevtech.composetodo.ui.theme.ComposeToDoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDark by remember {
                mutableStateOf(false)
            }
            val modalBottomSheetState =
                rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
            val scope = rememberCoroutineScope()
            val list = mainViewModel.toDoList
            ComposeToDoTheme(darkTheme = isDark) {
                Scaffold(topBar = {
                    ActionBar(onAddClick = {
                        scope.launch {
                            modalBottomSheetState.show()
                        }
                    }) {
                        isDark = !isDark
                    }
                }) {
                    ModalBottomSheetLayout(
                        sheetState = modalBottomSheetState,
                        sheetContent = {
                            var title by remember {
                                mutableStateOf("")
                            }
                            var content by remember {
                                mutableStateOf("")
                            }
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .verticalScroll(
                                        rememberScrollState()
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                            ) {
                                TextField(
                                    value = title,
                                    onValueChange = { title = it },
                                    label = { Text("Title") },
                                )
                                TextField(
                                    value = content,
                                    onValueChange = { content = it },
                                    label = { Text("Content") },
                                )
                                Button(onClick = {
                                    if (title.isNotBlank() && content.isNotBlank()) {
                                        mainViewModel.add(
                                            ToDo(
                                                id = System.currentTimeMillis(),
                                                title = title,
                                                content = content,
                                                created = System.currentTimeMillis(),
                                            )
                                        )
                                        scope.launch {
                                           modalBottomSheetState.hide()
                                        }
                                    }
                                }) {
                                    Text("Add")
                                }
                            }
                        }
                    ) {
                        LazyColumn {
                            items(list, key = { it.id }) {
                                ToDoItem(toDo = it, onClick = {}, onDelete = mainViewModel::delete)
                            }
                        }
                    }
                }
            }
        }
    }
}


