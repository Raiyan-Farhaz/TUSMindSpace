
package com.example.tusmindspace.database

// Import Room Database annotations
import androidx.room.Entity
import androidx.room.PrimaryKey

// Create a database table called "moods"
@Entity(tableName = "moods")
data class MoodEntity(

    // Unique ID for each mood (generated automatically)
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Stores the mood selected by the student

    val mood: String,

    // Stores the date and time when the mood was saved
    val date: Long = System.currentTimeMillis()
)


