package com.example.englishtraining
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.englishtraining.ui.vocabularyquiz.VocabularyQuizViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.verify
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class VocabularyQuizViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: VocabularyQuizViewModel

    @Before
    fun setup() {
        viewModel = VocabularyQuizViewModel()
    }

    @Test
    fun setQuestion_UpdatesCurrentPosition() {
        val observer = Mockito.mock(Observer::class.java) as Observer<Int>
        viewModel.currentPosition.observeForever(observer)

        viewModel.setQuestion(2)

        val captor = ArgumentCaptor.forClass(Int::class.java)
        verify(observer, Mockito.atLeastOnce()).onChanged(captor.capture())
        assert(captor.allValues.contains(2))
    }

    @Test
    fun selectOption_UpdatesSelectedOptionPosition() {
        val observer = Mockito.mock(Observer::class.java) as Observer<Int>
        viewModel.selectedOptionPosition.observeForever(observer)

        viewModel.selectOption(3)

        val captor = ArgumentCaptor.forClass(Int::class.java)
        verify(observer, Mockito.atLeastOnce()).onChanged(captor.capture())
        assert(captor.allValues.contains(3))
    }

    @Test
    fun incrementCorrectAnswer_UpdatesCorrectAnswer() {
        val observer = Mockito.mock(Observer::class.java) as Observer<Int>
        viewModel.correctAnswer.observeForever(observer)

        viewModel.incrementCorrectAnswer()

        val captor = ArgumentCaptor.forClass(Int::class.java)
        verify(observer, Mockito.atLeastOnce()).onChanged(captor.capture())
        assert(captor.allValues.contains(1))
    }

    @Test
    fun resetSelectedOption_ResetsSelectedOptionPosition() {
        val observer = Mockito.mock(Observer::class.java) as Observer<Int>
        viewModel.selectedOptionPosition.observeForever(observer)

        viewModel.resetSelectedOption()

        val captor = ArgumentCaptor.forClass(Int::class.java)
        verify(observer, Mockito.atLeastOnce()).onChanged(captor.capture())
        assert(captor.allValues.contains(0))
    }
}
