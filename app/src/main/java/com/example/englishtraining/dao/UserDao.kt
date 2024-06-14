package com.example.englishtraining.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User): Long

    @Query("select * from users where username = :username and password = :password")
    suspend fun loginUser(username: String, password: String): User?

    @Query("SELECT * FROM users WHERE id = :userId LIMIT 1")
    suspend fun getUser(userId: Int): User?

    @Update
    suspend fun update(user: User)
}