
package com.example.tusmindspace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// This function creates the Mood Tracker screen
@Composable
fun MoodScreen(
    onBackClick: () -> Unit,
    onHistoryClick: () -> Unit // NEW: Opens Mood History
) {

    Column(modifier = Modifier.padding(24.dp)) {

        // Screen heading
        Text(
            text = "Mood Tracker",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("How are you feeling today?")

        Spacer(modifier = Modifier.height(20.dp))

        // NEW: Button to open Mood History
        Button(onClick = onHistoryClick) {
            Text("View Mood History")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Existing Back button
        Button(onClick = onBackClick) {
            Text("Back to Home")
        }
    }
}
