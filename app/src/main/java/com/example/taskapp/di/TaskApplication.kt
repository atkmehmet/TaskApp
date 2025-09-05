package com.example.taskapp.di

import android.content.Context
import androidx.room.Room
import com.example.taskapp.domain.Repository.TaskRepository
import com.example.taskapp.domain.UseCase.AddTaskUseCase
import com.example.taskapp.domain.UseCase.GetTaskUseCase
import com.example.taskapp.local.Dao.TaskDao
import com.example.taskapp.local.Database.TaskDatabase
import com.example.taskapp.local.Repository.TaskRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun dataBase(@ApplicationContext context: Context):TaskDatabase{

        return  Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "taskDB"
        ).build()
    }

    @Provides
    fun getDao(taskDatabase: TaskDatabase):TaskDao{
       return taskDatabase.getTaskDao()
    }

    @Provides
    fun getRepository(taskDao: TaskDao):TaskRepository{
        return TaskRepositoryImp(taskDao)
    }

    @Provides
    fun usecaseAddProvides(repository: TaskRepository):AddTaskUseCase{
        return AddTaskUseCase(repository )
    }

    @Provides
    fun usecaseGetTaskAddProvides(repository: TaskRepository):GetTaskUseCase{
        return GetTaskUseCase(repository )
    }
}