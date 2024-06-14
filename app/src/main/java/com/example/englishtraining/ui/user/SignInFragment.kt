package com.example.englishtraining.ui.user

import android.content.Context
import android.content.Intent
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
import com.example.englishtraining.MainActivity
import com.example.englishtraining.R
import com.example.englishtraining.UserActivity
import com.google.android.material.button.MaterialButton

class SignInFragment: Fragment() {
    // getting userActivity reference to navigates between it's fragments
    private var userActivity: UserActivity? = null
    private val userViewModel: UserViewModel by viewModels()

    // to have the context reference
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is UserActivity) {
            userActivity = context
        } else {
            throw RuntimeException("$context must implement UserActivity")
        }
    }

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

        // Sign up button to navigate to signup fragment
        val textButtonSignUp = view.findViewById<MaterialButton>(R.id.textButtonSignUp)

        textButtonSignUp.setOnClickListener {
            userActivity?.showFragment(SignUpFragment())
        }

        //Observe the login status
        userViewModel.LoginResult.observe(viewLifecycleOwner, Observer{ success ->
            if(success){
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                //navigate to MainActivity and send username
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra("USER_NAME", userNameEditText.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        })
        return view
    }
}