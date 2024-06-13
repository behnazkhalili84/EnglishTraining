package com.example.englishtraining.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_results")
data class QuizResult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userName: String,
    val totalQuestions: Int,
    val correctAnswers: Int,
    val dateOfQuiz: String
)