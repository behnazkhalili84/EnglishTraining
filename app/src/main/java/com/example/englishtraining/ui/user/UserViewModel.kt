package com.example.englishtraining.ui.user

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room

import com.example.englishtraining.dao.QuizResultDao

import com.example.englishtraining.SecurePreferencesHelper

import com.example.englishtraining.dao.User
import com.example.englishtraining.dao.UserDao
import com.example.englishtraining.dao.UserDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val db = Room.databaseBuilder(application,UserDatabase::class.java,"user_database")
        .fallbackToDestructiveMigration()
        .build()
    private var userDao: UserDao = db.userDao()

    public var quizResultDao: QuizResultDao = db.quizResultDao()

    //for the shared preferences
    private val securePreferencesHelper = SecurePreferencesHelper(application)

    //using LiveData to avoid memory leak
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user


    private val _LoginResult = MutableLiveData<Boolean>()
    val LoginResult: LiveData<Boolean> get() = _LoginResult

    init {
        loadUser()
    }

    private fun loadUser() {
        viewModelScope.launch {
            val userId = securePreferencesHelper.getUserId()
            _user.postValue(userDao.getUser(userId))
        }
    }

    fun signIn(username: String, password: String) {
        viewModelScope.launch {
             val user = userDao.loginUser(username, password)
            // save user id securely in shared preferences
            user?.let {
                securePreferencesHelper.saveUserId(it.id)
            }
            _LoginResult.postValue(user != null)

        }

    }


    fun signUp(username: String, password: String) {
        viewModelScope.launch {
            val newUser = User(username = username, password = password)
            val newUserId = userDao.insert(newUser)
            // to update the user ID in preferences
            val insertedUser = userDao.getUser(newUserId.toInt())
            insertedUser?.let {
                securePreferencesHelper.saveUserId(it.id)
                _user.postValue(it)
            }
            _LoginResult.postValue(true)
        }
    }

    fun updateUser(updatedUsername: String, updatedPassword: String) {
        viewModelScope.launch {
            val userId = securePreferencesHelper.getUserId()
            val currentUser = userDao.getUser(userId)
            currentUser?.let {
                val updatedUser = it.copy(username = updatedUsername, password = updatedPassword)
                userDao.update(updatedUser)
                _user.postValue(updatedUser)
            }
        }

    }
}