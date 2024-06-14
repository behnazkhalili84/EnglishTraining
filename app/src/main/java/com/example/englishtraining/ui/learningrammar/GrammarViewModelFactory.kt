package com.example.englishtraining.ui.learningrammar

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.englishtraining.ui.learningvocabulary.VocabularyViewModel

class GrammarViewModelFactory (private val application: Application) : ViewModelProvider.NewInstanceFactory()  {


        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GrammarViewModel::class.java)) {
                return GrammarViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
