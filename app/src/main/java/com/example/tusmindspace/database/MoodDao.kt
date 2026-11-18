
package com.example.tusmindspace.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// DAO = Data Access Object
// Handles saving and reading moods from the database
@Dao
interface MoodDao {

    // Save a new mood
    @Insert
    suspend fun insertMood(mood: MoodEntity)

    // Get all saved moods, newest first
    @Query("SELECT * FROM moods ORDER BY date DESC")
    fun getAllMoods(): Flow<List<MoodEntity>>
}
