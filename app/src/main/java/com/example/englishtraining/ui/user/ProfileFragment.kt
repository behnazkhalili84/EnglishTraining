package com.example.englishtraining.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.englishtraining.R
import kotlinx.coroutines.launch

class ProfileFragment: Fragment() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val usernameEditText = view.findViewById<EditText>(R.id.usernameProfile)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordProfile)
        val editButton = view.findViewById<Button>(R.id.editButton)
        val saveButton = view.findViewById<Button>(R.id.saveButton)

        // Observe user data from ViewModel
        userViewModel.user.observe(viewLifecycleOwner, Observer { user ->
            usernameEditText.setText(user?.username)
            passwordEditText.setText(user?.password)
        })

        // Show the Save button when Edit button is clicked
        editButton.setOnClickListener {
            usernameEditText.isEnabled = true
            passwordEditText.isEnabled = true
            saveButton.visibility = View.VISIBLE
            editButton.visibility = View.GONE
        }

        // Handle Save button click
        saveButton.setOnClickListener {
            val updatedUsername = usernameEditText.text.toString()
            val updatedPassword = passwordEditText.text.toString()
            lifecycleScope.launch {
                userViewModel.updateUser(updatedUsername, updatedPassword)
                usernameEditText.isEnabled = false
                passwordEditText.isEnabled = false
                saveButton.visibility = View.GONE
                editButton.visibility = View.VISIBLE
                Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}