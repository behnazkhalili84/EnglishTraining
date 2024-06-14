package com.example.englishtraining.ui.resultVocabulary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.englishtraining.MainActivity
import com.example.englishtraining.R
import com.example.englishtraining.dao.QuizRepository
import com.example.englishtraining.dao.QuizResult
import com.example.englishtraining.dao.QuizResultDao
import com.example.englishtraining.ui.user.UserViewModel
import com.example.englishtraining.ui.vocabularyquiz.Constants
import kotlinx.coroutines.launch

class ResultVocabulary : Fragment() {

    private lateinit var tvScore: TextView
    private lateinit var tvName: TextView
    private lateinit var btnFinish: Button
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result_vocabulary, container, false)

        tvName = view.findViewById(R.id.tv_name)
        tvScore = view.findViewById(R.id.tv_score)
        btnFinish = view.findViewById(R.id.btn_finish)
        val userName = arguments?.getString(Constants.USER_NAME)
        val totalQuestions = arguments?.getInt(Constants.TOTAL_QUESTIONS, 0) ?: 0
        val correctAnswers = arguments?.getInt(Constants.CORRECT_ANSWERS, 0) ?: 0

        tvName.text = userName
        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions"

        btnFinish.setOnClickListener {
            val username = tvName.text.toString()
            val score = correctAnswers

            lifecycleScope.launch {
                Log.d("VocabularyScore", "Score question: $score")
                userViewModel.quizResultDao.insertResult(QuizResult(0, username, totalQuestions, score, "20241010"))
            }

            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }

        return view
    }

    companion object {
        fun newInstance(userName: String, totalQuestions: Int, correctAnswers: Int): ResultVocabulary {
            return ResultVocabulary().apply {
                arguments = Bundle().apply {
                    putString(Constants.USER_NAME, userName)
                    putInt(Constants.TOTAL_QUESTIONS, totalQuestions)
                    putInt(Constants.CORRECT_ANSWERS, correctAnswers)
                }
            }
        }
    }
}