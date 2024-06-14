package com.example.englishtraining.ui.vocabularyquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.englishtraining.R
import com.example.englishtraining.ui.resultVocabulary.ResultVocabulary

import com.google.android.material.button.MaterialButton

const val ARG_PARAM1 = "param1"
const val ARG_PARAM2 = "param2"

class VocabularyQuiz : Fragment() {

    private val viewModel: VocabularyQuizViewModel by viewModels()

    private lateinit var tvQuestion: TextView
    private lateinit var ivImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvOptionOne: TextView
    private lateinit var tvOptionTwo: TextView
    private lateinit var tvOptionThree: TextView
    private lateinit var tvOptionFour: TextView
    private lateinit var btnSubmit: MaterialButton
    private lateinit var userName: String

    private var selectedOptionPosition: Int = 0
    private var isAnswerSubmitted = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vocabulary_quiz, container, false)
        setupUI(view)
        setupObservers()
        setupListeners()
        viewModel.setQuestion(0)
        return view
    }

    private fun setupUI(view: View) {
        tvQuestion = view.findViewById(R.id.tv_question)
        ivImage = view.findViewById(R.id.iv_image)
        progressBar = view.findViewById(R.id.progressBar)
        tvProgress = view.findViewById(R.id.tv_progress)
        tvOptionOne = view.findViewById(R.id.tv_option_one)
        tvOptionTwo = view.findViewById(R.id.tv_option_two)
        tvOptionThree = view.findViewById(R.id.tv_option_three)
        tvOptionFour = view.findViewById(R.id.tv_option_four)
        btnSubmit = view.findViewById(R.id.btn_submit)

        progressBar.max = viewModel.questionsList.value?.size ?: 1
        tvProgress.text = "1/${progressBar.max}"
        progressBar.progress = 1
    }

    private fun setupObservers() {
        viewModel.currentPosition.observe(viewLifecycleOwner, Observer { position ->
            Log.d("VocabularyQuiz", "Current Position: $position")
            setQuestion(position)
        })

        viewModel.selectedOptionPosition.observe(viewLifecycleOwner, Observer { position ->
            Log.d("VocabularyQuiz", "Selected Option Position: $position")
            selectedOptionPosition = position
            resetOptionsBackground()
            highlightSelectedOption(position)
        })
    }

    private fun setupListeners() {
        tvOptionOne.setOnClickListener { onOptionSelected(1) }
        tvOptionTwo.setOnClickListener { onOptionSelected(2) }
        tvOptionThree.setOnClickListener { onOptionSelected(3) }
        tvOptionFour.setOnClickListener { onOptionSelected(4) }

        btnSubmit.setOnClickListener { onSubmit() }
    }

    private fun onOptionSelected(option: Int) {
        if (!isAnswerSubmitted) {
            selectedOptionPosition = option
            Log.d("VocabularyQuiz", "Option Selected: $option")
            viewModel.selectOption(option)
        }
    }

    private fun onSubmit() {
        val question = viewModel.questionsList.value?.get(viewModel.currentPosition.value ?: 0)
        if (!isAnswerSubmitted) {
            if (selectedOptionPosition == 0) {
                Toast.makeText(activity, "Please select an option", Toast.LENGTH_SHORT).show()
            } else {
                isAnswerSubmitted = true
                if (question != null && selectedOptionPosition == question.correctAnswer) {
                    Log.d("VocabularyQuiz", "Correct answer selected")
                    viewModel.incrementCorrectAnswer()
                }
                showAnswerFeedback(question!!.correctAnswer, R.drawable.correct_option_border_bg)
                if (selectedOptionPosition != question.correctAnswer) {
                    showAnswerFeedback(selectedOptionPosition, R.drawable.wrong_option_border_bg)
                }
                btnSubmit.text = if (viewModel.currentPosition.value == viewModel.questionsList.value?.size) "FINISH" else "NEXT"
            }
        } else {
            isAnswerSubmitted = false
            viewModel.setQuestion((viewModel.currentPosition.value ?: 0) + 1)
            btnSubmit.text = "SUBMIT"
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun showAnswerFeedback(answer: Int, drawableView: Int) {
        Log.d("VocabularyQuiz", "Show Answer Feedback: answer=$answer, drawableView=$drawableView")
        when (answer) {
            1 -> tvOptionOne.background = resources.getDrawable(drawableView, null)
            2 -> tvOptionTwo.background = resources.getDrawable(drawableView, null)
            3 -> tvOptionThree.background = resources.getDrawable(drawableView, null)
            4 -> tvOptionFour.background = resources.getDrawable(drawableView, null)
            else -> Log.e("VocabularyQuiz", "Invalid answer: $answer")
        }
    }

    private fun setQuestion(position: Int) {
        val questionList = viewModel.questionsList.value
        if (position < questionList?.size ?: 0) {
            val question = questionList?.get(position)

            Log.d("VocabularyQuiz", "Setting question: $question")

            tvQuestion.text = question?.question
            ivImage.setImageResource(question?.image ?: 0)
            progressBar.progress = position + 1
            tvProgress.text = "${position + 1}/${progressBar.max}"
            tvOptionOne.text = question?.optionOne
            tvOptionTwo.text = question?.optionTwo
            tvOptionThree.text = question?.optionThree
            tvOptionFour.text = question?.optionFour

            resetOptionsBackground()
            btnSubmit.text = "SUBMIT"
        } else {
            Toast.makeText(activity, "Quiz Completed", Toast.LENGTH_SHORT).show()
            Log.d("VocabularyQuiz", "Quiz completed")
            val bundle = Bundle().apply {
                putInt(Constants.TOTAL_QUESTIONS, viewModel.questionsList.value!!.size)
                putInt(Constants.CORRECT_ANSWERS, viewModel.correctAnswer.value ?: 0)
                putString(Constants.USER_NAME, "User Name") // Replace with actual user name
            }

            findNavController().navigate(
                R.id.action_vocabularyQuiz_to_resultVocabulary,
                bundle
            )
        }

    }

    private fun resetOptionsBackground() {
        tvOptionOne.background = resources.getDrawable(R.drawable.default_option_border_bg, null)
        tvOptionTwo.background = resources.getDrawable(R.drawable.default_option_border_bg, null)
        tvOptionThree.background = resources.getDrawable(R.drawable.default_option_border_bg, null)
        tvOptionFour.background = resources.getDrawable(R.drawable.default_option_border_bg, null)
    }

    private fun highlightSelectedOption(position: Int) {
        when (position) {
            1 -> tvOptionOne.background = resources.getDrawable(R.drawable.selected_option_border_bg, null)
            2 -> tvOptionTwo.background = resources.getDrawable(R.drawable.selected_option_border_bg, null)
            3 -> tvOptionThree.background = resources.getDrawable(R.drawable.selected_option_border_bg, null)
            4 -> tvOptionFour.background = resources.getDrawable(R.drawable.selected_option_border_bg, null)
            else -> Log.e("VocabularyQuiz", "Invalid selected option position: $position")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VocabularyQuiz().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}