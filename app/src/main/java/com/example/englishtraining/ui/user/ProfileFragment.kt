package com.example.englishtraining.ui.user

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.englishtraining.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class ProfileFragment: Fragment() {
    private val userViewModel: UserViewModel by viewModels()

    private lateinit var profileImageView: ImageView
    private lateinit var editImageButton: FloatingActionButton
    // Register the activity result launcher for camera and gallery intents
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            profileImageView.setImageURI(it)
        }
    }

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap: Bitmap? ->
        bitmap?.let {
            profileImageView.setImageBitmap(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val usernameEditText = view.findViewById<EditText>(R.id.usernameProfile)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordProfile)
        val editButton = view.findViewById<Button>(R.id.editButton)
        val saveButton = view.findViewById<Button>(R.id.saveButton)
        val cancelButton = view.findViewById<Button>(R.id.cancel_button)
        profileImageView = view.findViewById(R.id.profileImageView)
        editImageButton = view.findViewById(R.id.editImageButton) //image edit button

        editImageButton.setOnClickListener {
            // Choosing options to either take a photo or select from gallery
            val options = arrayOf("Take Photo", "Choose from Gallery")
            val builder = androidx.appcompat.app.AlertDialog.Builder(requireContext())
            builder.setTitle("Edit Profile Picture")
            builder.setItems(options) { dialog, which ->
                when (which) {
                    0 -> takePicture.launch(null) // Take photo
                    1 -> getContent.launch("image/*") // Choose from gallery
                }
            }
            builder.show()
        }

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
            cancelButton.visibility = View.VISIBLE
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

        cancelButton.setOnClickListener {
            // Observe user data from ViewModel
            userViewModel.user.observe(viewLifecycleOwner, Observer { user ->
                usernameEditText.setText(user?.username)
                passwordEditText.setText(user?.password)
            })
            usernameEditText.isEnabled = false
            passwordEditText.isEnabled = false
            saveButton.visibility = View.GONE
            cancelButton.visibility = View.GONE
            editButton.visibility = View.VISIBLE
        }

        return view
    }
}