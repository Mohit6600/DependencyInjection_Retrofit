package com.example.dependencyinjection_retrofit.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [UserData::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract  fun userDao() : UserDao

}