
package com.example.tusmindspace.database

import androidx.room.Database
import androidx.room.RoomDatabase

// Define Room database

@Database(
    entities = [MoodEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // Gives access to the MoodDao functions
    abstract fun moodDao(): MoodDao
}
