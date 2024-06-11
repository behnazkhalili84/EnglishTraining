package com.example.englishtraining.ui.learningvocabulary

import androidx.lifecycle.ViewModel

class VocabularyViewModel : ViewModel() {

    private val _vocabularyList = mutableListOf<Vocabulary>()
    val vocabularyList: List<Vocabulary>
        get() = _vocabularyList

    private val itemsPerPage = 8

    init {
        _vocabularyList.add(Vocabulary(1,"apple", "A round fruit", "R.drawable.apple", "http://",))
        _vocabularyList.add(Vocabulary(2,"drink", "I like sweet drinks", "R.drawable.drink", "http://",))
        _vocabularyList.add(Vocabulary(3,"water", "she is thirsty, she needs water ", "R.drawable.apple", "http://",))
        _vocabularyList.add(Vocabulary(4,"juice", "I drink orange juice", "R.drawable.juice", "http://",))
        _vocabularyList.add(Vocabulary(5,"toes", "My toes hurt", "R.drawable.toes", "http://",))
        _vocabularyList.add(Vocabulary(6,"nose", "A big nose", "R.drawable.nose", "http://",))
        _vocabularyList.add(Vocabulary(7,"mouth", "A beautiful mouth", "R.drawable.nose", "http://",))
        _vocabularyList.add(Vocabulary(8,"chair", "Sit down on the chair", "R.drawable.apple", "http://",))
        _vocabularyList.add(Vocabulary(9,"milk", "A drink milk every day", "R.drawable.milk", "http://",))
        _vocabularyList.add(Vocabulary(10,"sweet", "don't eat too much sweets", "R.drawable.sweets", "http://",))
        _vocabularyList.add(Vocabulary(11,"cup", "I drink in my cup", "R.drawable.cup", "http://",))
        _vocabularyList.add(Vocabulary(12,"biscuit", "A chocolate biscuit", "R.drawable.biscuit", "http://",))
        _vocabularyList.add(Vocabulary(13,"Mummy and baby", "Mummy loves her baby", "R.drawable.mambaby", "http://",))
        _vocabularyList.add(Vocabulary(14,"plate", "Wash your plate", "R.drawable.plate", "http://",))
        _vocabularyList.add(Vocabulary(15,"plate", "I ate at the table", "R.drawable.table", "http://",))
        _vocabularyList.add(Vocabulary(16,"daddy", "I love my daddy", "R.drawable.dady", "http://",))

    }

    fun getVocabularyPage(page: Int): List<Vocabulary> {
        val startIndex = (page - 1) * itemsPerPage
        return if (startIndex >= _vocabularyList.size) {
            emptyList()
        } else {
            _vocabularyList.subList(startIndex, minOf(startIndex + itemsPerPage, _vocabularyList.size))
        }

    }
}