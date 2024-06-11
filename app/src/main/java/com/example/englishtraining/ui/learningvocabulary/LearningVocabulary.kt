package com.example.englishtraining.ui.learningvocabulary

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.englishtraining.R


class LearningVocabulary : Fragment() {

    val viewModel: VocabularyViewModel by viewModels()


    override fun onCreateView  (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_vocabulary, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstPageRecyclerView = view.findViewById<RecyclerView>(R.id.firstPageRecyclerView)
        val secondPageRecyclerView = view.findViewById<RecyclerView>(R.id.secondPageRecyclerView)

        // Set Layout Managers
        firstPageRecyclerView.layoutManager = LinearLayoutManager(context)
        secondPageRecyclerView.layoutManager = LinearLayoutManager(context)

        // Access the vocabulary items after the view is created
        val firstPageItems = viewModel.getVocabularyPage(1)
        val secondPageItems = viewModel.getVocabularyPage(2)

        Log.d("LearningVocabulary", "First Page Items: $firstPageItems")
        Log.d("LearningVocabulary", "Second Page Items: $secondPageItems")


        firstPageRecyclerView.adapter = VocabularyAdapter(requireContext(), firstPageItems)
        secondPageRecyclerView.adapter = VocabularyAdapter(requireContext(), secondPageItems)
    }


}