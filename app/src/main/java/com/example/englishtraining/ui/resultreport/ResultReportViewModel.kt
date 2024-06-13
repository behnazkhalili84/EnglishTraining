package com.example.englishtraining.ui.resultreport

import android.app.Application
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.englishtraining.dao.QuizResult
import com.example.englishtraining.dao.QuizResultDao
import com.example.englishtraining.dao.UserDatabase
import com.example.englishtraining.ui.user.UserViewModel

class ResultReportViewModel(application: Application, private val userViewModel: UserViewModel) : AndroidViewModel(application) {
    val allQuizResults: LiveData<List<QuizResult>> = userViewModel.quizResultDao.getAllResults()
}