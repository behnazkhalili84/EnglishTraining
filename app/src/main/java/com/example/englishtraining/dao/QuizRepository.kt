package com.example.englishtraining.dao

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.englishtraining.SecurePreferencesHelper

class QuizRepository(private val quizResultDao: QuizResultDao, context: Context) {

    private val securePreferencesHelper = SecurePreferencesHelper(context)
    private val userId = securePreferencesHelper.getUserId()

    val allResults: LiveData<List<QuizResult>> = quizResultDao.getAllResults(userId)

    suspend fun insertResult(userId: Int,quizType :String, score: Int, totalQuestions: Int) {
        val result = QuizResult(id = 0, userId = userId,quizType, score, totalQuestions, 20241010.toString())
        quizResultDao.insertResult(result)
    }
}
