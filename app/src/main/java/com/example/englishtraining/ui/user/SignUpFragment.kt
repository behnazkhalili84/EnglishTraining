package com.example.englishtraining.ui.user

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.englishtraining.MainActivity
import com.example.englishtraining.R

class SignUpFragment: Fragment() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        val userNameEditText = view.findViewById<EditText>(R.id.UserName)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val signUpButton = view.findViewById<Button>(R.id.signUpButton)

        signUpButton.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val password = passwordEditText.text.toString()
            userViewModel.signUp(userName, password)
        }

        //Observe the login status
        userViewModel.LoginResult.observe(viewLifecycleOwner, Observer{ success ->
            if(success){
                Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                //navigate to MainActivity
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Sign Up Failed", Toast.LENGTH_SHORT).show()
            }
        })
        return view
    }

}