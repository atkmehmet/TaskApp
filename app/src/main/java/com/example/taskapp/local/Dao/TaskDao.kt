package com.example.taskapp.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskapp.local.Entity.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)


    @Query("SELECT * FROM TaskEntity")
    suspend fun getAllTask():List<TaskEntity>

    @Query("UPDATE TaskEntity set finished=True where taskId=:id")
    suspend fun getTaskFinished(id:Int)

}