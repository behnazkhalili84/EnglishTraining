package com.example.englishtraining.ui.resultGrammar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.englishtraining.dao.QuizResultDao

class ResultGrammarModelView  : ViewModel() {
    lateinit var quizResultDao: QuizResultDao
    private val _correctAnswers = MutableLiveData<Int>()
    val correctAnswers: LiveData<Int> get() = _correctAnswers

    private val _totalQuestions = MutableLiveData<Int>()
    val totalQuestions: LiveData<Int> get() = _totalQuestions

    fun setResults(correct: Int, total: Int) {
        _correctAnswers.value = correct
        _totalQuestions.value = total
    }
}