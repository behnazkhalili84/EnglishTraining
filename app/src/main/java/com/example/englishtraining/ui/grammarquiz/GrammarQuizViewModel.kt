package com.example.englishtraining.ui.grammarquiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.englishtraining.ui.vocabularyquiz.Constants
import com.example.englishtraining.ui.vocabularyquiz.VocabularyQuestion

class GrammarQuizViewModel : ViewModel() {

    private val _questionsList = MutableLiveData<List<GrammarQuestion>>()
    val questionsList: LiveData<List<GrammarQuestion>> get() = _questionsList

    private val _currentPosition = MutableLiveData(1)
    val currentPosition: LiveData<Int> get() = _currentPosition

    private val _selectedOptionPosition = MutableLiveData(0)
    val selectedOptionPosition: LiveData<Int> get() = _selectedOptionPosition

    private val _correctAnswer = MutableLiveData(0)
    val correctAnswer: LiveData<Int> get() = _correctAnswer

    init {
        _questionsList.value = ConstantsGrammar.getQuestions()
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
