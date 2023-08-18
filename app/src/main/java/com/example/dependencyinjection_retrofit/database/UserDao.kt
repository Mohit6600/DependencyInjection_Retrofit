package com.example.dependencyinjection_retrofit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

@Insert
suspend fun insertUser(userData : UserData)

@Query("SELECT * FROM UserData")
 suspend fun getAllUser(): List<UserData>
}