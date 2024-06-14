package com.example.englishtraining.ui.learningrammar

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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.englishtraining.R
import com.example.englishtraining.ui.learningvocabulary.VocabularyViewModel
import com.google.android.material.button.MaterialButton


class LearningGrammar : Fragment() {

    private lateinit var viewModel: GrammarViewModel

    private lateinit var ivImage: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvLetter: TextView
    private lateinit var tvExample1: TextView
    private lateinit var tvExample2: TextView
    private lateinit var tvExample3: TextView
    private lateinit var btnPlayAudio: MaterialButton
    private lateinit var btnNext: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_learning_grammar, container, false)
        setupUI(view)
        setupListeners()

        viewModel = ViewModelProvider(this).get(GrammarViewModel::class.java)
        viewModel.setLetter(0)

        setupObservers()
        return view
    }

    private fun setupUI(view: View) {
        ivImage = view.findViewById(R.id.iv_image)
        progressBar = view.findViewById(R.id.progressBar)
        tvProgress = view.findViewById(R.id.tv_progress)
        tvLetter = view.findViewById(R.id.letter)
        btnPlayAudio = view.findViewById(R.id.btn_play_audio)
        tvExample1= view.findViewById(R.id.example1)
        tvExample2= view.findViewById(R.id.example2)
        tvExample3= view.findViewById(R.id.example3)
        btnNext = view.findViewById(R.id.btn_next)


    }

    private fun setupObservers() {
        // Check if viewModel is initialized before setting up observers
        if (!::viewModel.isInitialized) {
            return
        }
        viewModel.currentPosition.observe(viewLifecycleOwner, Observer { position ->
            Log.d("Grammar Learning", "Current Position: $position")
            setLetter(position)
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
        if (newPosition < viewModel.grammerList.value?.size ?: 0) {
            // Update the current position
            viewModel.setLetter(newPosition)

            // Update the button text
            btnNext.text =  if (viewModel.currentPosition.value == viewModel.grammerList.value?.size) "FINISH" else "NEXT"
        } else {
            // Display a message indicating that the lesson is completed
            Toast.makeText(activity, "Lesson Completed", Toast.LENGTH_SHORT).show()
            viewModel.setLetter((viewModel.currentPosition.value ?: 0) + 1)
            btnNext.text = "Next"
        }
    }

    private fun setLetter(position: Int) {
        val grammarList = viewModel.grammerList.value
        if (position < (grammarList?.size ?: 0)) {
            val letter = grammarList?.get(position)

            Log.d( " GrammarLearning", "Setting letter: $letter")

            tvLetter.text = letter?.letter
            ivImage.setImageResource(letter?.imageRes ?: R.drawable.aimage)
            progressBar.progress = position
            tvProgress.text = "${position + 1}/${progressBar.max}"
            tvExample1.text = letter?.example1
            tvExample2.text = letter?.example2
            tvExample3.text = letter?.example3



        } else {
            Toast.makeText(activity, "Lesson Completed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        viewModel.currentPosition.removeObservers(viewLifecycleOwner)
        super.onDestroyView()
        viewModel.stopAudio()
    }


    }
