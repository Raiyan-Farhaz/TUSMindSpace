
package com.example.tusmindspace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tusmindspace.viewmodel.MoodViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Creates the Mood History screen
@Composable
fun MoodHistoryScreen(
    onBackClick: () -> Unit,
    moodViewModel: MoodViewModel
) {

    // Read saved moods from Room Database
    val moods by moodViewModel.allMoods.collectAsState(
        initial = emptyList()
    )

    Column(modifier = Modifier.padding(24.dp)) {

        // Screen heading
        Text(
            text = "Mood History",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Existing description
        Text("Your mood changes over time")

        Spacer(modifier = Modifier.height(24.dp))

        // Display saved moods from Room Database
        if (moods.isEmpty()) {

            Text("No moods saved yet.")

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(moods) { mood ->

                    // Convert saved timestamp into a readable date
                    val date = SimpleDateFormat(
                        "dd MMM yyyy, hh:mm a",
                        Locale.getDefault()
                    ).format(Date(mood.date))

                    // Show saved mood and date
                    Text(
                        text = "${mood.mood} - $date"
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Return to Mood Tracker
        Button(onClick = onBackClick) {
            Text("Back to Mood Tracker")
        }
    }
}
