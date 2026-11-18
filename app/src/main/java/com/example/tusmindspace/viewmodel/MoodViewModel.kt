
package com.example.tusmindspace.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tusmindspace.database.MoodDao
import com.example.tusmindspace.database.MoodEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

// ViewModel connects the Mood screens to the database
class MoodViewModel(
    private val moodDao: MoodDao
) : ViewModel() {

    // Get all saved moods from Room Database
    val allMoods: Flow<List<MoodEntity>> =
        moodDao.getAllMoods()

    // Save the mood selected by the student
    fun saveMood(selectedMood: String) {

        // Run database operation in a coroutine
        viewModelScope.launch {

            // Create a new mood record
            val newMood = MoodEntity(
                mood = selectedMood
            )

            // Insert the mood into the database
            moodDao.insertMood(newMood)
        }
    }
}
