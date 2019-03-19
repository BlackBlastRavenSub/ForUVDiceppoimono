package com.example.foruvdice2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    //abstract fun userDao(): UserDao
    abstract fun DiceDataDao():DiceDataDao
}
