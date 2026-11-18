
package com.example.tusmindspace.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.tusmindspace.R
// This function creates Home screen
@Composable
fun HomeScreen(
    onMoodClick: () -> Unit,
    onJournalClick: () -> Unit,
    onMeditationClick: () -> Unit,
    onResourcesClick: () -> Unit
) {

    // Column arranges everything vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Top row with app symbol and notification bell
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display the image from drawable
            Image(
                painter = painterResource(id = R.drawable.home_logo),
                contentDescription = "TUSMindSpace Logo",
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.width(32.dp))

            // Notification icon (not clickable yet)
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notifications",
                modifier = Modifier.size(40.dp),
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // App title
        Text(
            text = "TUSMindSpace.",
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(6.dp))

        // App subtitle
        Text(
            text = "Your wellbeing companion at TUS",
            fontSize = 12.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Card 1 - Mood Tracker
        HomeMenuCard(
            title = "Mood Tracker",
            onClick = onMoodClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Card 2 - Personal Journal
        HomeMenuCard(
            title = "Personal Journal",
            onClick = onJournalClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Card 3 - Guided Meditation
        HomeMenuCard(
            title = "Guided Meditation",
            onClick = onMeditationClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Card 4 - Wellbeing Resources
        HomeMenuCard(
            title = "Wellbeing Resources",
            onClick = onResourcesClick
        )
    }
}

// Reusable card for all four menu options
@Composable
fun HomeMenuCard(
    title: String,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(
                color = Color(0xFFD9D9D9),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 20.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        // Name of the screen
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black
        )

        // Arrow on the right
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Open $title",
            tint = Color.Black
        )
    }
}
