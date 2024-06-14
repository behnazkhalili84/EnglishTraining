package com.example.englishtraining

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.englishtraining.dao.QuizResult
import com.example.englishtraining.ui.resultVocabulary.ResultVocabularyModelView
import com.example.englishtraining.ui.resultreport.ResultReportViewModel
import com.example.englishtraining.ui.user.UserViewModel
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun resultReportViewModel_fetchResults_isCorrect() {
        val application = mock(Application::class.java)
        val userViewModel = mock(UserViewModel::class.java)
        val viewModel = ResultReportViewModel(application, userViewModel)

        // Assuming QuizResult has appropriate equals method
        val expectedResults = listOf(
            QuizResult(userId = 1, quizType = "Vocabulary Quiz", totalQuestions = 10, correctAnswers = 7, dateOfQuiz = "20241011")
        )

        `when`(userViewModel.quizResultDao.getAllResults(1)).thenReturn(MutableLiveData(expectedResults))

        assertEquals(expectedResults, viewModel.allQuizResults.value)
    }
}