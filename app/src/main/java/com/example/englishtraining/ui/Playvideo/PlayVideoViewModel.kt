package com.example.englishtraining.ui.Playvideo

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayVideoViewMode : ViewModel() {
    private val _videoUri = MutableLiveData<Uri>()
    val videoUri: LiveData<Uri> get() = _videoUri

    fun setVideoUri(uri: Uri) {
        _videoUri.value = uri
    }

}