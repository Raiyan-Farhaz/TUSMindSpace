
package com.example.tusmindspace.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tusmindspace.R

@Composable
fun MeditationScreen(
    onBackClick: () -> Unit,
    onHistoryClick: () -> Unit
) {

    // Arrange everything vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Screen title
        Text(
            text = "Guided Meditation",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display the image from drawable
        Image(
            painter = painterResource(id = R.drawable.guided_meditation),
            contentDescription = "Guided Meditation",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Description
        Text("Take a short break and relax with a guided exercise")

        Spacer(modifier = Modifier.height(32.dp))

        // First exercise card
        MeditationCard("Breathing Exercise", "5 mins")

        Spacer(modifier = Modifier.height(16.dp))

        // Second exercise card
        MeditationCard("Relaxation", "10 mins")

        Spacer(modifier = Modifier.height(16.dp))

        // Third exercise card
        MeditationCard("Stress Relief", "10 mins")

        Spacer(modifier = Modifier.weight(1f))

        // Open Meditation History
        Button(onClick = onHistoryClick) {
            Text("View Meditation History")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Return to Home
        Button(onClick = onBackClick) {
            Text("Back to Home")
        }
    }
}

// Reusable card for meditation exercises
@Composable
fun MeditationCard(
    name: String,
    duration: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.LightGray,
                RoundedCornerShape(10.dp)
            )
            .padding(18.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        // Play symbol
        Text("▶")

        Spacer(modifier = Modifier.width(10.dp))

        // Exercise name
        Text(
            text = name,
            modifier = Modifier.weight(1f)
        )

        // Duration
        Text(duration)

        Spacer(modifier = Modifier.width(8.dp))

        // Arrow
        Text("→")
    }
}
