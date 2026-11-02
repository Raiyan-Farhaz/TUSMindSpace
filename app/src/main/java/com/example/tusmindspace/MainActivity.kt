
package com.example.tusmindspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

// Navigation imports
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Import our screens
import com.example.tusmindspace.screens.HomeScreen
import com.example.tusmindspace.screens.MoodScreen
import com.example.tusmindspace.screens.JournalScreen

// Import our app theme
import com.example.tusmindspace.ui.theme.TUSMindSpaceTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start the Jetpack Compose UI
        setContent {
            TUSMindSpaceTheme {
                TUSMindSpaceApp()
            }
        }
    }
}


// This function manages navigation between screens
@Composable
fun TUSMindSpaceApp() {

    // Create a navigation controller
    val navController = rememberNavController()

    // Define all the screens and their routes
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        // Home screen
        composable("home") {
            HomeScreen(
                onMoodClick = {
                    navController.navigate("mood")
                },
                onJournalClick = {
                    navController.navigate("journal")
                },
                // Meditation will be added later
                onMeditationClick = {}
            )
        }

        // Mood Tracker screen
        composable("mood") {
            MoodScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // Journal screen
        composable("journal") {
            JournalScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
