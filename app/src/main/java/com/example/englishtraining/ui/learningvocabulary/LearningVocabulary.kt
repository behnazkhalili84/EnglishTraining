package com.example.englishtraining.ui.learningvocabulary

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.englishtraining.R
import com.example.englishtraining.ui.vocabularyquiz.VocabularyQuiz
import com.google.android.material.button.MaterialButton


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LearningVocabulary : Fragment() {

    private val viewModel: VocabularyViewModel by viewModels()


    private lateinit var ivImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvWord: TextView
    private lateinit var tvexampleSentence: TextView
    private lateinit var tvaudioUrl: TextView

    private lateinit var btnNext: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_learning_vocabulary, container, false)
        setupUI(view)
        setupListeners()
//       setWord(0)
        return view

    }

    private fun setupUI(view: View) {
        ivImage = view.findViewById(R.id.iv_image)
        progressBar = view.findViewById(R.id.progressBar)
        tvProgress = view.findViewById(R.id.tv_progress)
        tvWord = view.findViewById(R.id.tv_word)
        tvexampleSentence = view.findViewById(R.id.tv_exampleSentence)
        tvaudioUrl = view.findViewById(R.id.tvaudioUrl)
        btnNext = view.findViewById(R.id.btn_next)
    }

    private fun setupListeners() {

        btnNext.setOnClickListener { onNext() }
    }

    private fun onNext() {
        // Increment the current position
        val newPosition = (viewModel.currentPosition.value ?: 0) + 1

        // Check if the new position is within the bounds of the list
        if (newPosition < viewModel.vocabularyList.value?.size ?: 0) {
            // Update the current position
            viewModel.setWord(newPosition)

            // Update the button text
            btnNext.text = if (newPosition == viewModel.vocabularyList.value?.size?.minus(1)) "FINISH" else "NEXT"
        } else {
            // Display a message indicating that the lesson is completed
            Toast.makeText(activity, "Lesson Completed", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setWord(position: Int) {
        val vocabularyList = viewModel.vocabularyList.value
        if (position < (vocabularyList?.size ?: 0)) {
            val word = vocabularyList?.get(position)

            tvWord.text = word?.word
            ivImage.setImageResource((word?.imageRes ?: R.drawable.apple) as Int)
            progressBar.progress = position
            tvProgress.text = "${position + 1}/${progressBar.max}"
            tvexampleSentence.text = word?.exampleSentence
            // Play audio
            playAudio(word?.audioUrl ?: "")


        } else {
            Toast.makeText(activity, "Quiz Completed", Toast.LENGTH_SHORT).show()
            // Handle quiz completion logic here
        }
    }



    private fun playAudio(audioUrl: String) {
        val mediaPlayer = MediaPlayer().apply {
            setDataSource(audioUrl)
            prepare()
            start()
        }
        mediaPlayer.setOnCompletionListener {
            it.release()
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VocabularyQuiz().apply {
                arguments = Bundle().apply {
                    putString(com.example.englishtraining.ui.vocabularyquiz.ARG_PARAM1, param1)
                    putString(com.example.englishtraining.ui.vocabularyquiz.ARG_PARAM2, param2)
                }
            }
    }
}
