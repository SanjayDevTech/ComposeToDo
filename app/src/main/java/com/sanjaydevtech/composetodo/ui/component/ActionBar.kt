package com.sanjaydevtech.composetodo.ui.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.sanjaydevtech.composetodo.R

@Composable
fun ActionBar(onAddClick: () -> Unit,onToggle: () -> Unit) {
    var showMenu by remember {
        mutableStateOf(false)
    }
    TopAppBar(title = {
        Text(stringResource(id = R.string.app_name))
    },
        actions = {
            IconButton(onClick = onToggle) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_invert_colors_24),
                    contentDescription = "Invert"
                )
            }
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(Icons.Default.MoreVert, "")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(onClick = {
                    onAddClick()
                    showMenu = false
                }) {
                    Text("Add Todo")
                }
            }
        })
}