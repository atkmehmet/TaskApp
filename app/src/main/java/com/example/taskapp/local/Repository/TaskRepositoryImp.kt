package com.example.taskapp.local.Repository

import com.example.taskapp.domain.Model.Task
import com.example.taskapp.domain.Repository.TaskRepository
import com.example.taskapp.local.Dao.TaskDao
import com.example.taskapp.local.Entity.TaskEntity

class TaskRepositoryImp(
    private val taskDao: TaskDao
):TaskRepository {
    override suspend fun addTask(task: Task) {
      taskDao.insertTask(
          TaskEntity(
              taskText = task.taskString,
              finished = task.taskFinished
          )
      )
    }

    override suspend fun getTask(): List<Task> {
        val listTasks = taskDao.getAllTask()
        return listTasks.map {
            Task(
                taskString = it.taskText,
                taskFinished = it.finished
            )
        }
    }
}