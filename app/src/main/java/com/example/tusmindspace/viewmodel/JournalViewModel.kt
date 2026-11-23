
package com.example.tusmindspace.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tusmindspace.database.JournalDao
import com.example.tusmindspace.database.JournalEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

// ViewModel connects the Journal screens to the database
class JournalViewModel(
    private val journalDao: JournalDao
) : ViewModel() {

    // Get all saved journal entries from Room Database
    val allJournals: Flow<List<JournalEntity>> =
        journalDao.getAllJournals()

    // Save the journal text written by the student
    fun saveJournal(journalText: String) {

        // Don't save an empty journal entry
        if (journalText.isBlank()) return

        // Run database operation in a coroutine
        viewModelScope.launch {

            // Create a new journal record
            val newJournal = JournalEntity(
                content = journalText
            )

            // Insert the journal into the database
            journalDao.insertJournal(newJournal)
        }
    }
}


