package com.example.taskapp.domain.UseCase

import com.example.taskapp.domain.Repository.TaskRepository

class GetTaskFinish(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(id:Int){
        repository.getTaskFinished(id)
    }
}