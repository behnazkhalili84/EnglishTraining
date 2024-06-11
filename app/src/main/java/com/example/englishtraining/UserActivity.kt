package com.example.englishtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.englishtraining.ui.user.SignInFragment
import com.example.englishtraining.ui.user.SignUpFragment

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        // Sign In is the default fragment
        showFragment(SignUpFragment())
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.user_fragment_container, fragment)
            .commit()
    }
}