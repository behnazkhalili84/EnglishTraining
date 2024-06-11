package com.example.englishtraining.ui.vocabularyquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< Updated upstream
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
=======
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.englishtraining.R
>>>>>>> Stashed changes
import com.google.android.material.button.MaterialButton

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

<<<<<<< Updated upstream
class VocabularyQuiz  : Fragment() {
=======
/**
 * A simple [Fragment] subclass.
 * Use the [VocabularyQuiz.newInstance] factory method to
 * create an instance of this fragment.
 */
class VocabularyQuiz : Fragment() {
>>>>>>> Stashed changes

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

    private var selectedOptionPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
<<<<<<< Updated upstream
=======
        // Inflate the layout for this fragment
>>>>>>> Stashed changes
        val view = inflater.inflate(R.layout.fragment_vocabulary_quiz, container, false)
        setupUI(view)
        setupObservers()
        setupListeners()
<<<<<<< Updated upstream
        // Set initial question
        viewModel.setQuestion(0)
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

        // Initialize progress bar and progress text for the first question
        progressBar.max = viewModel.questionsList.value?.size ?: 1
        tvProgress.text = "1/${progressBar.max}"
        progressBar.progress = 1
=======
>>>>>>> Stashed changes
    }

    private fun setupObservers() {
        viewModel.currentPosition.observe(viewLifecycleOwner, Observer { position ->
            setQuestion(position)
        })

        viewModel.selectedOptionPosition.observe(viewLifecycleOwner, Observer { position ->
            selectedOptionPosition = position
<<<<<<< Updated upstream
            resetOptionsBackground()
            highlightSelectedOption(position)
=======
>>>>>>> Stashed changes
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
        selectedOptionPosition = option
        viewModel.selectOption(option)
    }

    private fun onSubmit() {
        val question = viewModel.questionsList.value?.get(viewModel.currentPosition.value ?: 0)
        if (selectedOptionPosition == 0) {
            // No option selected, go to next question
            viewModel.setQuestion((viewModel.currentPosition.value ?: 0) + 1)
        } else {
            if (question != null && selectedOptionPosition == question.correctAnswer) {
                viewModel.incrementCorrectAnswer()
            }
<<<<<<< Updated upstream
            showAnswerFeedback(question!!.correctAnswer, R.drawable.correct_option_border_bg)
            if (selectedOptionPosition != question.correctAnswer) {
                showAnswerFeedback(selectedOptionPosition, R.drawable.wrong_option_border_bg)
            }

            // Reset selected option position
            viewModel.resetSelectedOption()
            if (viewModel.currentPosition.value!! >= viewModel.questionsList.value!!.size) {
                // Use Bundle to pass data to ResultVocabulary fragment
                val bundle = Bundle().apply {
                    putInt(Constants.TOTAL_QUESTIONS, viewModel.questionsList.value!!.size)
                    putInt(Constants.CORRECT_ANSWERS, viewModel.correctAnswer.value ?: 0)
                    putString(Constants.USER_NAME, "User Name") // Replace with actual user name
                }
                val resultVocabularyFragment = ResultVocabulary().apply {
                    arguments = bundle
                }
                fragmentManager?.beginTransaction()?.replace(R.id.nav_vocabularyresult, resultVocabularyFragment)?.commit()
            } else {
                viewModel.setQuestion(viewModel.currentPosition.value!! + 1)
                btnSubmit.text = if (viewModel.currentPosition.value == viewModel.questionsList.value?.size) "FINISH" else "NEXT"
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun showAnswerFeedback(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> tvOptionOne.background = resources.getDrawable(drawableView, null)
            2 -> tvOptionTwo.background = resources.getDrawable(drawableView, null)
            3 -> tvOptionThree.background = resources.getDrawable(drawableView, null)
            4 -> tvOptionFour.background = resources.getDrawable(drawableView, null)
=======
            // Reset selected option position
            selectedOptionPosition = 0
            viewModel.setQuestion((viewModel.currentPosition.value ?: 0) + 1)
>>>>>>> Stashed changes
        }
    }

    private fun setQuestion(position: Int) {
        val questionList = viewModel.questionsList.value
        if (position < questionList?.size ?: 0) {
            val question = questionList?.get(position)

            tvQuestion.text = question?.question
            ivImage.setImageResource(question?.image ?: 0)
<<<<<<< Updated upstream
            progressBar.progress = position + 1
=======
            progressBar.progress = position
>>>>>>> Stashed changes
            tvProgress.text = "${position + 1}/${progressBar.max}"
            tvOptionOne.text = question?.optionOne
            tvOptionTwo.text = question?.optionTwo
            tvOptionThree.text = question?.optionThree
            tvOptionFour.text = question?.optionFour

<<<<<<< Updated upstream
            resetOptionsBackground()
=======
            tvOptionOne.background = resources.getDrawable(R.drawable.default_option_border_bg, null)
            tvOptionTwo.background = resources.getDrawable(R.drawable.default_option_border_bg, null)
            tvOptionThree.background = resources.getDrawable(R.drawable.default_option_border_bg, null)
            tvOptionFour.background = resources.getDrawable(R.drawable.default_option_border_bg, null)
>>>>>>> Stashed changes
        } else {
            Toast.makeText(activity, "Quiz Completed", Toast.LENGTH_SHORT).show()
            // Handle quiz completion logic here
        }
<<<<<<< Updated upstream
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
        }
=======
>>>>>>> Stashed changes
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
