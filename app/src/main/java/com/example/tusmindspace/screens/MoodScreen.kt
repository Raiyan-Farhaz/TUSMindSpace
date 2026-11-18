
package com.example.tusmindspace.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tusmindspace.R
import com.example.tusmindspace.viewmodel.MoodViewModel

// This function creates the Mood Tracker screen
@Composable
fun MoodScreen(
    onBackClick: () -> Unit,
    onHistoryClick: () -> Unit,
    moodViewModel: MoodViewModel
) {

    // Temporarily remembers the selected mood
    var selectedMood by remember { mutableStateOf("") }

    // Shows confirmation after clicking Save Mood
    var saveMessage by remember { mutableStateOf("") }

    // Column arranges everything vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Top row: back arrow and heading
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "←",
                fontSize = 26.sp,
                modifier = Modifier.clickable {
                    onBackClick()
                }
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Mood Tracker",
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Question
        Text(
            text = "How are you feeling today?",
            fontSize = 16.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(30.dp))

        // First row: Happy and Okay
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            MoodCard(
                mood = "Happy",
                imageId = R.drawable.happy,
                selectedMood = selectedMood,
                onClick = {
                    selectedMood = "Happy"
                    saveMessage = ""
                }
            )

            MoodCard(
                mood = "Okay",
                imageId = R.drawable.okay,
                selectedMood = selectedMood,
                onClick = {
                    selectedMood = "Okay"
                    saveMessage = ""
                }
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        // Second row: Sad and Stressed
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            MoodCard(
                mood = "Sad",
                imageId = R.drawable.sad,
                selectedMood = selectedMood,
                onClick = {
                    selectedMood = "Sad"
                    saveMessage = ""
                }
            )

            MoodCard(
                mood = "Stressed",
                imageId = R.drawable.stressed,
                selectedMood = selectedMood,
                onClick = {
                    selectedMood = "Stressed"
                    saveMessage = ""
                }
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        // Third row: Very Happy (centered)
        MoodCard(
            mood = "Very Happy",
            imageId = R.drawable.very_happy,
            selectedMood = selectedMood,
            onClick = {
                selectedMood = "Very Happy"
                saveMessage = ""
            }
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Save selected mood into Room Database
        Button(
            onClick = {

                // Call ViewModel to save the selected mood
                moodViewModel.saveMood(selectedMood)

                // Display confirmation message
                saveMessage = "Mood submitted for saving!"

                // Clear selected mood
                selectedMood = ""
            },
            enabled = selectedMood.isNotEmpty(),
            modifier = Modifier.fillMaxWidth(0.75f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD9D9D9),
                contentColor = Color.Black,
                disabledContainerColor = Color(0xFFD9D9D9),
                disabledContentColor = Color.DarkGray
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text("Save Mood")
        }

        // Show confirmation message
        if (saveMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = saveMessage,
                fontSize = 13.sp,
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Opens the existing Mood History screen
        Button(
            onClick = onHistoryClick,
            modifier = Modifier.fillMaxWidth(0.75f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD9D9D9),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text("View Mood History")
        }
    }
}

// Reusable card for each mood image
@Composable
fun MoodCard(
    mood: String,
    imageId: Int,
    selectedMood: String,
    onClick: () -> Unit
) {

    // Check if this mood is currently selected
    val isSelected = selectedMood == mood

    Column(
        modifier = Modifier
            .size(width = 110.dp, height = 105.dp)
            .background(
                color = if (isSelected)
                    Color(0xFFBDBDBD)
                else
                    Color(0xFFD9D9D9),
                shape = RoundedCornerShape(4.dp)
            )
            .clickable {
                onClick()
            }
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Display image from drawable
        Image(
            painter = painterResource(id = imageId),
            contentDescription = mood,
            modifier = Modifier.size(52.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Mood name below the image
        Text(
            text = mood,
            fontSize = 14.sp,
            color = Color.Black
        )

        // Show check mark when selected
        if (isSelected) {
            Text(
                text = "✓",
                fontSize = 12.sp,
                color = Color.Black
            )
        }
    }
}
