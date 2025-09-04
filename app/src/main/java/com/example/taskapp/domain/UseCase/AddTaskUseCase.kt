package com.example.taskapp.domain.UseCase

import com.example.taskapp.domain.Model.Task
import com.example.taskapp.domain.Repository.TaskRepository

class AddTaskUseCase(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(task: Task){
        taskRepository.addTask(task)
    }
}