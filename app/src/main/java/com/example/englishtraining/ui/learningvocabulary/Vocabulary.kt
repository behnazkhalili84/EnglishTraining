package com.example.englishtraining.ui.learningvocabulary

data class Vocabulary(
    val id : Int,
    val word: String,
    val exampleSentence: String,
    val imageRes: String? = null, // Optional: URL to an image representing the word
    val audioUrl: String? = null // Optional: URL to an audio file for pronunciation
)
