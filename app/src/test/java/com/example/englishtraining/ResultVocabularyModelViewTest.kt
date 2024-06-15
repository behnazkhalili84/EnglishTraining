package com.example.englishtraining

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.englishtraining.ui.resultVocabulary.ResultVocabularyModelView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ResultVocabularyModelViewTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ResultVocabularyModelView

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = ResultVocabularyModelView()
    }

    @Test
    fun testSetResults() {
        val correctAnswersObserver = Mockito.mock(Observer::class.java) as Observer<Int>
        val totalQuestionsObserver = Mockito.mock(Observer::class.java) as Observer<Int>

        viewModel.correctAnswers.observeForever(correctAnswersObserver)
        viewModel.totalQuestions.observeForever(totalQuestionsObserver)

        viewModel.setResults(5, 10)

        Mockito.verify(correctAnswersObserver).onChanged(5)
        Mockito.verify(totalQuestionsObserver).onChanged(10)
    }
}