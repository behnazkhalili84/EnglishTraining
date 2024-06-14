package com.example.englishtraining.dao

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.englishtraining.SecurePreferencesHelper

class QuizRepository(private val quizResultDao: QuizResultDao, context: Context) {

    private val securePreferencesHelper = SecurePreferencesHelper(context)
    private val userId = securePreferencesHelper.getUserId()

    val allResults: LiveData<List<QuizResult>> = quizResultDao.getAllResults(userId)

    suspend fun insertResult(username: String, score: Int, totalQuestions: Int) {
        val result = QuizResult(id = 0, username, score, totalQuestions, 20241010.toString())
        quizResultDao.insertResult(result)
    }
}
