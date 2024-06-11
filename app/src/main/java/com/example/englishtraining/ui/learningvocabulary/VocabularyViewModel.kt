package com.example.englishtraining.ui.learningvocabulary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.englishtraining.ui.vocabularyquiz.Constants
import com.example.englishtraining.ui.vocabularyquiz.VocabularyQuestion

class VocabularyViewModel : ViewModel() {


    private val _vocabularyList = MutableLiveData<List<Vocabulary>>()
    val vocabularyList: MutableLiveData<List<Vocabulary>> get() = _vocabularyList

    init {
        // Initialize vocabulary list here using Constants1 object
        _vocabularyList.value = Constants1.getVocabulary1()
    }
    private val _currentPosition = MutableLiveData(1)
    val currentPosition: LiveData<Int> get() = _currentPosition


    fun setWord(position: Int) {
        _currentPosition.value = position
    }



}