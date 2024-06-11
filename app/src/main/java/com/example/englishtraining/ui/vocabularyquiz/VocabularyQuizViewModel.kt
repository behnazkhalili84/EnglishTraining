package com.example.englishtraining.ui.vocabularyquiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VocabularyQuizViewModel : ViewModel() {

    private val _questionsList = MutableLiveData<List<VocabularyQuestion>>()
    val questionsList: LiveData<List<VocabularyQuestion>> get() = _questionsList

    private val _currentPosition = MutableLiveData(1)
    val currentPosition: LiveData<Int> get() = _currentPosition

    private val _selectedOptionPosition = MutableLiveData(0)
    val selectedOptionPosition: LiveData<Int> get() = _selectedOptionPosition

    private val _correctAnswer = MutableLiveData(0)
    val correctAnswer: LiveData<Int> get() = _correctAnswer

    init {
        _questionsList.value = Constants.getQuestions()
    }

    fun setQuestion(position: Int) {
        _currentPosition.value = position
    }

    fun selectOption(position: Int) {
        _selectedOptionPosition.value = position
    }

    fun incrementCorrectAnswer() {
        _correctAnswer.value = (_correctAnswer.value ?: 0) + 1
    }


    fun resetSelectedOption() {
        _selectedOptionPosition.value = 0
    }
}
