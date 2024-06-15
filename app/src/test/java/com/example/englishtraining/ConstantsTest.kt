package com.example.englishtraining
import com.example.englishtraining.R
import com.example.englishtraining.ui.vocabularyquiz.Constants
import org.junit.Assert.assertEquals
import org.junit.Test

class ConstantsTest {

    @Test
    fun getQuestions_ShouldReturnNonEmptyList() {
        // Act
        val questionsList = Constants.getQuestions()

        // Assert
        assertEquals(8, questionsList.size)
    }

    @Test
    fun getQuestions_CheckFirstQuestion() {
        // Act
        val questionsList = Constants.getQuestions()

        // Assert
        assertEquals(1, questionsList[0].id)
        assertEquals("What is this?", questionsList[0].question)
        assertEquals(R.drawable.apple, questionsList[0].image)
        assertEquals("drink", questionsList[0].optionOne)
        assertEquals("water", questionsList[0].optionTwo)
        assertEquals("apple", questionsList[0].optionThree)
        assertEquals("nose", questionsList[0].optionFour)
        assertEquals(3, questionsList[0].correctAnswer)
    }

    // Add similar tests for other questions if needed
}
