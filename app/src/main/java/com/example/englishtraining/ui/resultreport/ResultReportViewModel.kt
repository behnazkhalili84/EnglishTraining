package com.example.englishtraining.ui.resultreport

import android.app.Application
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.englishtraining.SecurePreferencesHelper
import com.example.englishtraining.dao.QuizResult
import com.example.englishtraining.ui.user.UserViewModel

class ResultReportViewModel(application: Application, private val userViewModel: UserViewModel) : AndroidViewModel(application) {
    val securePreferencesHelper = SecurePreferencesHelper(application.applicationContext)
    val userId = securePreferencesHelper.getUserId()

    val allQuizResults: LiveData<List<QuizResult>> = userViewModel.quizResultDao.getAllResults(userId)
}