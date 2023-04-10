package com.example.atm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.atm.data.dao.UserDao
import com.example.atm.data.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}