package com.example.englishtraining.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "com/example/englishtraining/ui/user")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val password: String,
)
