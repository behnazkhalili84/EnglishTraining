package com.example.englishtraining.ui.learningvocabulary

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.englishtraining.R
import com.example.englishtraining.ui.vocabularyquiz.VocabularyQuiz
import com.google.android.material.button.MaterialButton
import java.io.IOException


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LearningVocabulary : Fragment() {

//    private var viewModel: VocabularyViewModel by viewModels()
private lateinit var viewModel: VocabularyViewModel


    private lateinit var ivImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvWord: TextView
    private lateinit var tvexampleSentence: TextView
    private lateinit var btnPlayAudio: MaterialButton
    private lateinit var btnNext: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_learning_vocabulary, container, false)

        viewModel = ViewModelProvider(this).get(VocabularyViewModel::class.java)
        setupUI(view)
        setupListeners()

        viewModel.setWord(0)

        setupObservers()
        return view

    }

    private fun setupUI(view: View) {
        ivImage = view.findViewById(R.id.iv_image)
        progressBar = view.findViewById(R.id.progressBar)
        tvProgress = view.findViewById(R.id.tv_progress)
        tvWord = view.findViewById(R.id.tv_word)
        tvexampleSentence = view.findViewById(R.id.tv_exampleSentence)
        btnPlayAudio = view.findViewById(R.id.btn_play_audio)
        btnNext = view.findViewById(R.id.btn_next)

        progressBar.max = viewModel.vocabularyList.value?.size ?: 1
        tvProgress.text = "1/${progressBar.max}"
        progressBar.progress = 1

    }

    private fun setupObservers() {
        // Check if viewModel is initialized before setting up observers
        if (!::viewModel.isInitialized) {
            return
        }
        viewModel.currentPosition.observe(viewLifecycleOwner, Observer { position ->
            Log.d("VocabularyLearning", "Current Position: $position")
            setWord(position)
        })

    }

    private fun setupListeners() {

        btnNext.setOnClickListener { onNext() }
        btnPlayAudio.setOnClickListener { viewModel.playAudio() }
    }

    private fun onNext() {
        // Increment the current position
        val newPosition = (viewModel.currentPosition.value ?: 0) + 1

        // Check if the new position is within the bounds of the list
        if (newPosition < viewModel.vocabularyList.value?.size ?: 0) {
            // Update the current position
            viewModel.setWord(newPosition)

            // Update the button text
            btnNext.text =  if (viewModel.currentPosition.value == viewModel.vocabularyList.value?.size) "FINISH" else "NEXT"
        } else {
            // Display a message indicating that the lesson is completed
            Toast.makeText(activity, "Lesson Completed", Toast.LENGTH_SHORT).show()
            viewModel.setWord((viewModel.currentPosition.value ?: 0) + 1)
            btnNext.text = "Next"
        }
    }


    private fun setWord(position: Int) {
        val vocabularyList = viewModel.vocabularyList.value
        if (position < (vocabularyList?.size ?: 0)) {
            val word = vocabularyList?.get(position)

            Log.d( " VocabularyLearning", "Setting word: $word")

            tvWord.text = word?.word
            ivImage.setImageResource(word?.imageRes ?: R.drawable.apple)
            progressBar.progress = position + 1
            tvProgress.text = "${position + 1}/${progressBar.max}"
            tvexampleSentence.text = word?.exampleSentence
            // Play audio
//            playAudio(word?.audioUrl ?: "")


        } else {
            Toast.makeText(activity, "Quiz Completed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        viewModel.currentPosition.removeObservers(viewLifecycleOwner)
        super.onDestroyView()
        viewModel.stopAudio()
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
