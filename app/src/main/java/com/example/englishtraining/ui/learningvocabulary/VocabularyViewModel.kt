package com.example.englishtraining.ui.learningvocabulary

import androidx.lifecycle.ViewModel

class VocabularyViewModel : ViewModel() {

    private val _vocabularyList = mutableListOf<Vocabulary>()
    val vocabularyList: List<Vocabulary>
        get() = _vocabularyList

init {
    _vocabularyList.add(Vocabulary("apple", "A round fruit", "R.drawable.apple", "http://",))
    _vocabularyList.add(Vocabulary("drink", "I like sweet drinks", "R.drawable.drink", "http://",))
    _vocabularyList.add(Vocabulary("water", "she is thirsty, she needs water ", "R.drawable.apple", "http://",))
    _vocabularyList.add(Vocabulary("juice", "I drink orange juice", "R.drawable.juice", "http://",))
    _vocabularyList.add(Vocabulary("toes", "My toes hurt", "R.drawable.toes", "http://",))
    _vocabularyList.add(Vocabulary("nose", "A big nose", "R.drawable.nose", "http://",))
    _vocabularyList.add(Vocabulary("mouth", "A beautiful mouth", "R.drawable.nose", "http://",))
    _vocabularyList.add(Vocabulary("chair", "Sit down on the chair", "R.drawable.apple", "http://",))
    _vocabularyList.add(Vocabulary("milk", "A drink milk every day", "R.drawable.milk", "http://",))
    _vocabularyList.add(Vocabulary("sweet", "don't eat too much sweets", "R.drawable.sweets", "http://",))
    _vocabularyList.add(Vocabulary("cup", "I drink in my cup","R.drawable.cup",  "http://",))
    _vocabularyList.add(Vocabulary("biscuit", "A chocolate biscuit", "R.drawable.biscuit", "http://",))
    _vocabularyList.add(Vocabulary("Mummy and baby", "Mummy loves her baby", "R.drawable.mambaby", "http://",))
    _vocabularyList.add(Vocabulary("plate", "Wash your plate", "R.drawable.plate", "http://",))
    _vocabularyList.add(Vocabulary("plate", "I ate at the table", "R.drawable.table", "http://",))
    _vocabularyList.add(Vocabulary("daddy", "I love my daddy", "R.drawable.dady", "http://",))

}

}