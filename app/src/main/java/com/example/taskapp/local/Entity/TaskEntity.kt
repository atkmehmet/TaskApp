package com.example.taskapp.local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskEntity (
  @PrimaryKey(autoGenerate = true)  val taskId:Int=0,
    val taskText:String,
    val finished:Boolean
    )