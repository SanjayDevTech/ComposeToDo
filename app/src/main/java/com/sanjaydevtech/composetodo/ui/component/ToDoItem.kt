package com.sanjaydevtech.composetodo.ui.component

import android.text.format.DateFormat
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sanjaydevtech.composetodo.model.ToDo
import java.util.*
import com.sanjaydevtech.composetodo.R

@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
@Composable
fun ToDoItem(
    toDo: ToDo,
    onClick: (ToDo) -> Unit,
    onDelete: (Long) -> Unit,
) {
    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { onClick(toDo) }
                .padding(8.dp),
        ) {
            Column(modifier = Modifier.fillMaxWidth(0.7f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(toDo.title, style = MaterialTheme.typography.h5)
                }
                Text(toDo.content, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
            IconButton(modifier = Modifier.padding(4.dp), onClick = {onClick(toDo)}) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_edit_24 ), contentDescription = "Edit")
            }
            IconButton(modifier = Modifier.padding(4.dp), onClick = {onDelete(toDo.id)}) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_delete_24 ), contentDescription = "Delete")
            }
        }
    }
}