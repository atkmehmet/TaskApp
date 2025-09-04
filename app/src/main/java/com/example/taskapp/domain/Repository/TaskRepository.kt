package com.example.taskapp.domain.Repository

import com.example.taskapp.domain.Model.Task

interface TaskRepository {

    suspend fun  addTask(task: Task)

    suspend fun getTask():List<Task>
}