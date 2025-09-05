package com.example.taskapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.domain.Model.Task
import com.example.taskapp.domain.UseCase.AddTaskUseCase
import com.example.taskapp.domain.UseCase.GetTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject  constructor(
    private val useCase: AddTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase
) :ViewModel() {

    var taskText by mutableStateOf("")
    var taskBoolean by mutableStateOf(false)
    var errorMessages by mutableStateOf("")

    fun add(){
        viewModelScope.launch {
            try {

                useCase.invoke(
                    Task(
                        taskString = taskText,
                        taskFinished = taskBoolean
                    )
                )
            }
            catch (ex:Exception){
                errorMessages = ex.toString()
            }
        }
    }
}