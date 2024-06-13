package com.example.englishtraining.ui.user

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.englishtraining.dao.QuizResultDao
import com.example.englishtraining.dao.User
import com.example.englishtraining.dao.UserDao
import com.example.englishtraining.dao.UserDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val db = Room.databaseBuilder(application,UserDatabase::class.java,"user_database").build()
    private var userDao: UserDao = db.userDao()
    public var quizResultDao: QuizResultDao = db.quizResultDao()

    //Using LiveData
    private val _LoginResult = MutableLiveData<Boolean>()
    val LoginResult: LiveData<Boolean> get() = _LoginResult

    fun signIn(username: String, password: String) {
        viewModelScope.launch {
            val user = userDao.loginUser(username, password)
            _LoginResult.postValue(user != null)
        }
    }


    fun signUp(username: String, password: String) {
        viewModelScope.launch {
            val user = User(username = username, password = password)
            userDao.insert(user)
            _LoginResult.postValue(true)
        }
    }
}