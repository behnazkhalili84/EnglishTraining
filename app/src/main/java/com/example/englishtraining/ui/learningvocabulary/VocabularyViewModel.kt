package com.example.englishtraining.ui.learningvocabulary

import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.englishtraining.ui.vocabularyquiz.Constants
import com.example.englishtraining.ui.vocabularyquiz.VocabularyQuestion

class VocabularyViewModel : ViewModel() {


    private val _vocabularyList = MutableLiveData<List<Vocabulary>>()
    val vocabularyList: MutableLiveData<List<Vocabulary>> get() = _vocabularyList
    private var mediaPlayer: MediaPlayer? = null
    init {
        // Initialize vocabulary list here using Constants1 object
        _vocabularyList.value = Constants1.getVocabulary1()
    }
    private val _currentPosition = MutableLiveData(1)
    val currentPosition: LiveData<Int> get() = _currentPosition


    fun setWord(position: Int) {
        _currentPosition.value = position
    }

    fun playAudio() {
        val vocabulary = vocabularyList.value?.get(currentPosition.value ?: 0)
        val audioUrl = vocabulary?.audioUrl ?: return

        stopAudio() // Stop any currently playing audio

         mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(audioUrl)
                prepare()
                start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun stopAudio() {
        mediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        mediaPlayer = null
    }

    override fun onCleared() {
        super.onCleared()
        stopAudio() // Ensure MediaPlayer is released when the ViewModel is cleared
    }
}