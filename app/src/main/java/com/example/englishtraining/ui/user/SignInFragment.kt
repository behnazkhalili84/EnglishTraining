package com.example.englishtraining.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.englishtraining.R

class SignInFragment: Fragment() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signin, container, false)
        val userNameEditText = view.findViewById<EditText>(R.id.UserName)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val signInButton = view.findViewById<Button>(R.id.signInButton)

        signInButton.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val password = passwordEditText.text.toString()
            userViewModel.signIn(userName, password)
        }

        //Observe the login status
        userViewModel.LoginResult.observe(viewLifecycleOwner, Observer{ success ->
            if(success){
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        })
        return view
    }
}