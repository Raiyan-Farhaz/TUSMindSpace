
package com.example.tusmindspace.database

import androidx.room.Database
import androidx.room.RoomDatabase

// Define Room database for moods and journals
@Database(
    entities = [
        MoodEntity::class,
        JournalEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // Gives access to MoodDao functions
    abstract fun moodDao(): MoodDao

    // Gives access to JournalDao functions
    abstract fun journalDao(): JournalDao
}
