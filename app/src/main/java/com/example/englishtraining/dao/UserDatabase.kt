package com.example.englishtraining.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class,QuizResult::class], version = 2, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun quizResultDao(): QuizResultDao
}