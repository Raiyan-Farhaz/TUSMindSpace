
package com.example.tusmindspace.screens

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tusmindspace.R
import com.example.tusmindspace.viewmodel.JournalViewModel

// This function creates the Personal Journal screen
@Composable
fun JournalScreen(
    onBackClick: () -> Unit,
    onHistoryClick: () -> Unit,
    journalViewModel: JournalViewModel
) {

    // Temporarily stores what the user types
    var journalText by remember { mutableStateOf("") }

    // Get context to display Toast messages
    val context = LocalContext.current

    // Column arranges everything vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        // Top row: back arrow and screen title
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Clickable back arrow
            Text(
                text = "←",
                fontSize = 26.sp,
                color = Color.Black,
                modifier = Modifier.clickable {
                    onBackClick()
                }
            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Personal Journal",
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Description below the title
        Text(
            text = "Write down your thoughts, feelings or anything on your mind",
            fontSize = 14.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Journal prompt box
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFFF0EAF8),
                    RoundedCornerShape(8.dp)
                )
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Display light bulb image from drawable
            Image(
                painter = painterResource(id = R.drawable.light_img),
                contentDescription = "Journal Prompt",
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            // Prompt text
            Column {

                Text(
                    text = "Journal Prompt:",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF673AB7)
                )

                Text(
                    text = "What made you feel good today?",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Large journal writing box
        OutlinedTextField(
            value = journalText,
            onValueChange = {
                journalText = it
            },
            placeholder = {
                Text(
                    text = "Start writing here...",
                    color = Color.DarkGray
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFD9D9D9),
                unfocusedContainerColor = Color(0xFFD9D9D9)
            )
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Save Entry button - connected to Room Database
        Button(
            onClick = {

                // Check if the student has written something
                if (journalText.isNotBlank()) {

                    // Request saving journal text using ViewModel
                    journalViewModel.saveJournal(journalText)

                    // Display confirmation message
                    Toast.makeText(
                        context,
                        "Journal entry saved!",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Clear the writing box
                    journalText = ""

                } else {

                    // Display message if writing box is empty
                    Toast.makeText(
                        context,
                        "Please write something first!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD9D9D9),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text("Save Entry")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // View Journal History button
        Button(
            onClick = {

                // Navigate to Journal History screen
                onHistoryClick()
            },
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD9D9D9),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text("View Journal History")
        }
    }
}
