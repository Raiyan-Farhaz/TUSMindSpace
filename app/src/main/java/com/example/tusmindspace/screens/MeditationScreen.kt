
package com.example.tusmindspace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// This function creates the Meditation screen
@Composable
fun MeditationScreen(
    onBackClick: () -> Unit,
    onHistoryClick: () -> Unit // NEW: Opens Meditation History
) {

    Column(modifier = Modifier.padding(24.dp)) {

        Text(
            text = "Guided Meditation",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Take a short break and relax with a guided exercise.")

        Spacer(modifier = Modifier.height(24.dp))

        // Existing meditation options
        Text("Breathing Exercise (5 mins)")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Relaxation (10 mins)")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Stress Relief (10 mins)")

        Spacer(modifier = Modifier.height(24.dp))

        // NEW: Opens Meditation History
        Button(onClick = onHistoryClick) {
            Text("View Meditation History")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Existing Back button
        Button(onClick = onBackClick) {
            Text("Back to Home")
        }
    }
}
