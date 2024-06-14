package com.example.englishtraining.ui.resultreport

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.englishtraining.R
import com.example.englishtraining.SecurePreferencesHelper
import com.example.englishtraining.dao.QuizResult
import com.example.englishtraining.ui.user.UserViewModel

class ResultReport : Fragment() {

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var resultContainer: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result_report, container, false)
        resultContainer = view.findViewById(R.id.resultContainer)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = requireContext()
        val securePreferencesHelper = SecurePreferencesHelper(context)
        val userId = securePreferencesHelper.getUserId()
        Log.d("USER_ID", "User ID: $userId")
        userViewModel.quizResultDao.getAllResults(userId).observe(viewLifecycleOwner, Observer { quizResults ->
            quizResults?.let { displayQuizResults(it) }
        })
    }

    private fun displayQuizResults(quizResults: List<QuizResult>) {
        resultContainer.removeAllViews()
        for (quizResult in quizResults) {
            val quizResultView = createQuizResultView(quizResult)
            resultContainer.addView(quizResultView)
        }
    }

    private fun createQuizResultView(quizResult: QuizResult): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_quiz_result, resultContainer, false)
        val userNameTextView: TextView = view.findViewById(R.id.userNameTextView)
        val totalQuestionsTextView: TextView = view.findViewById(R.id.totalQuestionsTextView)
        val correctAnswersTextView: TextView = view.findViewById(R.id.correctAnswersTextView)
        val dateOfQuizTextView: TextView = view.findViewById(R.id.dateOfQuizTextView)
        userViewModel.loadUser()
        userViewModel.user.observe(viewLifecycleOwner, Observer { user ->
            userNameTextView.setText(user?.username)
        })

//        userNameTextView.text = quizResult.userName
        Log.d("USER_NAME", "USER_NAME: $userNameTextView")
        totalQuestionsTextView.text = "Total Questions: ${quizResult.totalQuestions}"
        correctAnswersTextView.text = "Correct Answers: ${quizResult.correctAnswers}"
        dateOfQuizTextView.text = "Date: ${quizResult.dateOfQuiz}"
        return view
    }
}