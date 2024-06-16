package com.example.englishtraining.ui.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.example.englishtraining.UserActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment: Fragment() {
    // getting userActivity reference to navigates between it's fragments
    private var userActivity: UserActivity? = null
    private val userViewModel: UserViewModel by viewModels()

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
    ): View {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        val userNameEditText = view.findViewById<EditText>(R.id.UserName)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val signUpButton = view.findViewById<Button>(R.id.signUpButton)
        // from material design for better error handling
        val userNameInputLayout = view.findViewById<TextInputLayout>(R.id.userNameInputLayout)
        val passwordInputLayout = view.findViewById<TextInputLayout>(R.id.passwordInputLayout)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val userName = userNameEditText.text.toString()
                val password = passwordEditText.text.toString()
                signUpButton.isEnabled = userViewModel.validateInput(userName, password, userNameInputLayout, passwordInputLayout)
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        userNameEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)

        // Sign up button
        signUpButton.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val password = passwordEditText.text.toString()
            userViewModel.signUp(userName, password)
        }

        // Sign in button to navigate to signin fragment
        val textButtonSignIn = view.findViewById<MaterialButton>(R.id.textButtonSignIn)

        textButtonSignIn.setOnClickListener {
            userActivity?.showFragment(SignInFragment())
        }

        //Observe the login status
        userViewModel.LoginResult.observe(viewLifecycleOwner, Observer{ success ->
            if(success){
                Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                //navigate to MainActivity
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra("USER_NAME", userNameEditText.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(context, "Sign Up Failed", Toast.LENGTH_SHORT).show()
            }
        })
        return view
    }

}