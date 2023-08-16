package com.example.dependencyinjection_retrofit.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserData")
data class UserData(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "username")val userName: String?,
    @ColumnInfo(name = "password")val password: String?

    )

