package com.example.englishtraining.ui.resultVocabulary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultVocabularyModelView  : ViewModel() {
    private val _correctAnswers = MutableLiveData<Int>()
    val correctAnswers: LiveData<Int> get() = _correctAnswers

    private val _totalQuestions = MutableLiveData<Int>()
    val totalQuestions: LiveData<Int> get() = _totalQuestions

    fun setResults(correct: Int, total: Int) {
        _correctAnswers.value = correct
        _totalQuestions.value = total
    }
}