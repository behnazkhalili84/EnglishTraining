package com.example.englishtraining

import com.example.englishtraining.ui.grammarquiz.ConstantsGrammar
import org.junit.Assert.*
import org.junit.Test

class ConstantsGrammarTest {

    @Test
    fun getQuestions_ReturnsCorrectNumberOfQuestions() {
        val questions = ConstantsGrammar.getQuestions()
        assertEquals(8, questions.size)
    }

    @Test
    fun getQuestions_CheckFirstQuestionDetails() {
        val questions = ConstantsGrammar.getQuestions()
        val firstQuestion = questions[0]

        assertEquals(1, firstQuestion.id)
        assertEquals("What is this?", firstQuestion.question)
        assertEquals(R.drawable.aimage, firstQuestion.image)
        assertEquals("D", firstQuestion.optionOne)
        assertEquals("B", firstQuestion.optionTwo)
        assertEquals("C", firstQuestion.optionThree)
        assertEquals("A", firstQuestion.optionFour)
        assertEquals(4, firstQuestion.correctAnswer)
    }
}
