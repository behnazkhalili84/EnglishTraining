package com.example.englishtraining

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.ui.*
import com.example.englishtraining.databinding.ActivityMainBinding
import com.example.englishtraining.ui.vocabularyquiz.Constants
import com.example.englishtraining.ui.user.UserViewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // retrieve username from UserActivity
        val userName = intent.getStringExtra("USER_NAME")
        //Bundle in Android is a way to pass data between components such as activities and fragments.
        Log.d("USER_NAME", "USER_NAME: $userName")
        val bundle = Bundle().apply {
            putString("userName", userName)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.setGraph(R.navigation.mobile_navigation, bundle)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_learningVocab , R.id.nav_learningGrammar, R.id.nav_vocabulayquiz, R.id.nav_grammarquiz,R.id.nav_quizVocabRep,
                R.id.profile
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Sign out
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.nav_home)
                    drawerLayout.closeDrawer(navView)
                    true
                }
                R.id.signout -> {
                    // Sign out the user
                    userViewModel.signOut()
                    // Navigate to the sign-in or welcome activity
                    val intent = Intent(this, UserActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> {
                    menuItem.onNavDestinationSelected(navController)
                    drawerLayout.closeDrawer(navView)
                    true
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}