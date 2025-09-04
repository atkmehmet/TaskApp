package com.example.taskapp.local.Database

import androidx.room.Database
import com.example.taskapp.local.Entity.TaskEntity
import com.example.taskapp.local.Dao.TaskDao

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase {
    abstract fun getTaskDao():TaskDao
}