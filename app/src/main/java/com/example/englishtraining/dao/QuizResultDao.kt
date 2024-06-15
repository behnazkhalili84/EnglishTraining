package com.example.englishtraining.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: QuizResult)

    @Query("SELECT * FROM quiz_results WHERE userId = :userId")
    fun getAllResults(userId: Int): LiveData<List<QuizResult>>
}