package com.example.dependencyinjection_retrofit.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserData")
data class UserData (
val userName : String,
val password : String,
val phoneNo : String
){

        @PrimaryKey(autoGenerate = true) var id : Long =0
}

