
package com.example.tusmindspace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Creates the Mood History screen
@Composable
fun MoodHistoryScreen(onBackClick: () -> Unit) {

    Column(modifier = Modifier.padding(24.dp)) {

        // Screen heading
        Text(
            text = "Mood History",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Placeholder for the future mood graph
        Text("Your mood changes over time")

        Spacer(modifier = Modifier.height(24.dp))

        // Return to Mood Tracker
        Button(onClick = onBackClick) {
            Text("Back to Mood Tracker")
        }
    }
}


