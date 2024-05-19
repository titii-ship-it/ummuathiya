package com.example.ummuathiya

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlumniModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun alumniDao(): AlumniDao
}