package com.example.englishtraining.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User): Long

    @Query("select * from users where username = :username and password = :password")
    suspend fun loginUser(username: String, password: String): User?
}