
package com.example.tusmindspace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// This function creates the Journal screen
@Composable
fun JournalScreen(onBackClick: () -> Unit) {

    // Column arranges items vertically
    Column(
        modifier = Modifier.padding(24.dp)
    ) {

        // Screen heading
        Text(
            text = "Personal Journal",
            style = MaterialTheme.typography.headlineMedium
        )

        // Space below heading
        Spacer(modifier = Modifier.height(20.dp))

        // Description
        Text("Write down your thoughts and feelings.")

        Spacer(modifier = Modifier.height(20.dp))

        // Button to return to previous screen
        Button(onClick = onBackClick) {
            Text("Back to Home")
        }
    }
}


