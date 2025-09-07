package com.example.taskapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable

fun TaskScreen(viewModel: TaskViewModel = hiltViewModel()) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)) {

        TextField(value = viewModel.taskText, onValueChange = {viewModel.taskText = it})

        Spacer(modifier = Modifier.height(10.dp))

        Checkbox(checked = viewModel.taskBoolean, onCheckedChange = {viewModel.taskBoolean= it})

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { viewModel.add() }) {
            Text(text = "Add Task")

        }

        Spacer(modifier = Modifier.height(10.dp))

        if (viewModel.errorMessages !="")
        {
            Text(text = viewModel.errorMessages)
        }
        viewModel.taskList.forEach {task ->
            Column {
                Text(text = task.id.toString())
                Text(text = task.taskString)
                Checkbox(checked = task.taskFinished, onCheckedChange = {viewModel.getTaskFinish(task.id)})
            }
        }
    }
}