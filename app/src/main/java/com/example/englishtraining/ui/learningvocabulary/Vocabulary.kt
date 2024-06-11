package com.example.englishtraining.ui.learningvocabulary

data class Vocabulary(
    val id : Int,
    val word: String,
    val exampleSentence: String,
    val imageRes: String,
    val audioUrl: String
)
