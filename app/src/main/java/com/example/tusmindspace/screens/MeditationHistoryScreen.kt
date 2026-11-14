
package com.example.tusmindspace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Creates the Meditation History screen
@Composable
fun MeditationHistoryScreen(onBackClick: () -> Unit) {

    Column(modifier = Modifier.padding(24.dp)) {

        // Screen heading
        Text(
            text = "Meditation History",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Placeholder for completed sessions
        Text("Your completed meditation sessions")

        Spacer(modifier = Modifier.height(20.dp))

        // Return to Guided Meditation
        Button(onClick = onBackClick) {
            Text("Back to Meditation")
        }
    }
}
