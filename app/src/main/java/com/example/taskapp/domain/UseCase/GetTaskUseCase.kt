package com.example.taskapp.domain.UseCase

import com.example.taskapp.domain.Model.Task
import com.example.taskapp.domain.Repository.TaskRepository

class GetTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke():List<Task>{
       return repository.getTask()
    }
}