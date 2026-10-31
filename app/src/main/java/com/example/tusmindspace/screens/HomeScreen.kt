package com.example.tusmindspace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// This function creates our Home screen
@Composable
fun HomeScreen(
    onMoodClick: () -> Unit,
    onJournalClick: () -> Unit,
    onMeditationClick: () -> Unit
) {

    // Column arranges items vertically
    Column(
        modifier = Modifier.padding(24.dp)
    ) {

        // App title
        Text(
            text = "Welcome to TUSMindSpace",
            style = MaterialTheme.typography.headlineMedium
        )

        // Space below the title
        Spacer(modifier = Modifier.height(24.dp))

        // Button 1 - Mood Tracker
        Button(onClick = onMoodClick) {
            Text("Mood Tracker")
        }

        // Button 2 - Journal
        Button(onClick = onJournalClick) {
            Text("Personal Journal")
        }

        // Button 3 - Meditation
        Button(onClick = onMeditationClick) {
            Text("Guided Meditation")
        }
    }
}