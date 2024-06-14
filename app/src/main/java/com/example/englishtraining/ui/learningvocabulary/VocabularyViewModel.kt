package com.example.englishtraining.ui.learningvocabulary

import android.app.Application
import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.content.Context
import androidx.lifecycle.AndroidViewModel


class VocabularyViewModel (application: Application): AndroidViewModel(application) {


    private val _vocabularyList = MutableLiveData<List<Vocabulary>>()
    val vocabularyList: MutableLiveData<List<Vocabulary>> get() = _vocabularyList
    private var mediaPlayer: MediaPlayer? = null
    private val applicationContext: Context = application.applicationContext

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

        val resId = applicationContext.resources.getIdentifier(audioUrl.toString(), "raw", applicationContext.packageName)
        if (resId == 0) {
            // Handle the error: resource not found
            return
        }

        val afd = applicationContext.resources.openRawResourceFd(resId)
        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                prepare()
                start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        afd.close()
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
