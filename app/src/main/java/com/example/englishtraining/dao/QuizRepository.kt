package com.example.englishtraining.dao

import androidx.lifecycle.LiveData

class QuizRepository (private val quizResultDao: QuizResultDao) {
    val allResults: LiveData<List<QuizResult>> = quizResultDao.getAllResults()

    suspend fun insertResult(username: String, score: Int, totalQuestions: Int) {
        val result = QuizResult(id = 0,username, score, totalQuestions, 20241010.toString())
        quizResultDao.insertResult(result)
    }
}