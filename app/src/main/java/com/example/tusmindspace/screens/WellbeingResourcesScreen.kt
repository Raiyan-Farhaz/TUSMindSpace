package com.example.tusmindspace.screens
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// This function creates the Wellbeing Resources screen
@Composable
fun WellbeingResourcesScreen(onBackClick: () -> Unit) {

    Column(
        modifier = Modifier.padding(24.dp)
    ) {

        // Screen title
        Text(
            text = "Wellbeing Resources",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Description
        Text("Find nearby support services at TUS and in Limerick.")

        Spacer(modifier = Modifier.height(24.dp))

        // Placeholder for Google Maps (later sprint)
        Text("Map will be displayed here")

        Spacer(modifier = Modifier.height(24.dp))

        // Support services
        Text("TUS Student Support")
        Text("Counselling Services")

        Spacer(modifier = Modifier.height(24.dp))

        // Return to Home
        Button(onClick = onBackClick) {
            Text("Back to Home")
        }
    }
}