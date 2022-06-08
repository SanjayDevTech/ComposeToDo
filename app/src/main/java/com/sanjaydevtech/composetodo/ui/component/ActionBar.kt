package com.sanjaydevtech.composetodo.ui.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.sanjaydevtech.composetodo.R

@Composable
fun ActionBar( onSettingsClick: () -> Unit, onToggle: () -> Unit) {
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
            IconButton(onClick = onSettingsClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                    contentDescription = "Settings"
                )
            }

        })
}