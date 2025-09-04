package com.example.taskapp.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity (
  @PrimaryKey(autoGenerate = true)  val taskId:Int,
    val taskText:String,
    val finished:Boolean
    )