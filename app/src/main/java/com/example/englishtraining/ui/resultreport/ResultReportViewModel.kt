package com.example.englishtraining.ui.resultreport

import android.app.Application
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.englishtraining.SecurePreferencesHelper
import com.example.englishtraining.dao.QuizResult
import com.example.englishtraining.ui.user.UserViewModel

class ResultReportViewModel(application: Application) : AndroidViewModel(application) {
    private val securePreferencesHelper = SecurePreferencesHelper(application.applicationContext)
    private val userId = securePreferencesHelper.getUserId()

    val allQuizResults: LiveData<List<QuizResult>> = UserViewModel(application).quizResultDao.getAllResults(userId)

    init {
        Log.d("ResultReportViewModel", "UserId: $userId")
        allQuizResults.observeForever { quizResults ->
            Log.d("ResultReportViewModel", "All quiz results changed: $quizResults")
            quizResults?.forEach { result ->
                Log.d("ResultReportViewModel", "QuizResult: $result")
            }
        }
    }
}