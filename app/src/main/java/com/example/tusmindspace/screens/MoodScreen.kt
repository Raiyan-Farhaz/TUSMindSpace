
package com.example.tusmindspace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// This function creates the Mood Tracker screen
@Composable
fun MoodScreen(onBackClick: () -> Unit) {

    // Arrange everything vertically
    Column(
        modifier = Modifier.padding(24.dp)
    ) {

        // Screen heading
        Text(
            text = "Mood Tracker",
            style = MaterialTheme.typography.headlineMedium
        )

        // Add space
        Spacer(modifier = Modifier.height(20.dp))

        // Description
        Text("How are you feeling today?")

        Spacer(modifier = Modifier.height(20.dp))

        // Back button
        Button(onClick = onBackClick) {
            Text("Back to Home")
        }
    }
}


