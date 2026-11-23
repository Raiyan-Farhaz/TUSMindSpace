
package com.example.tusmindspace.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// DAO = Data Access Object
// Handles saving and reading journal entries
@Dao
interface JournalDao {

    // Save a new journal entry
    @Insert
    suspend fun insertJournal(journal: JournalEntity)

    // Get all saved journal entries, newest first
    @Query("SELECT * FROM journals ORDER BY date DESC")
    fun getAllJournals(): Flow<List<JournalEntity>>
}


