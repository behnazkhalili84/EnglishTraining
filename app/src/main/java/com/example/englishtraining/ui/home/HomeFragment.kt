package com.example.englishtraining.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.englishtraining.R
import com.example.englishtraining.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            val username = arguments?.getString("USER_NAME")
//            textView.text = username + "'s " + it
//        }
        binding.grammarLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_grammarFragment)
        }

        binding.vocabularyLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_vocabularyFragment)
        }

        binding.vocabularyQuizLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_vocabularyQuizFragment)
        }

        binding.grammarQuizLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_grammarQuizFragment)
        }

        binding.awardLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_awardFragment)
        }

        binding.calendarLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_calendarFragment)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}