package com.example.tusmindspace.database

import androidx.room.Entity
import androidx.room.PrimaryKey

// Create a database table called "journals"
@Entity(tableName = "journals")
data class JournalEntity(

    // Unique ID for each journal entry
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Stores the text written by the student
    val content: String,

    // Stores the date and time of the entry
    val date: Long = System.currentTimeMillis()
)
