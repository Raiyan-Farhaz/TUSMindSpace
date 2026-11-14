
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
import com.example.tusmindspace.screens.MeditationScreen
import com.example.tusmindspace.screens.WellbeingResourcesScreen

// NEW: Import history screens
import com.example.tusmindspace.screens.MoodHistoryScreen
import com.example.tusmindspace.screens.MeditationHistoryScreen

// App theme
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

    // Create navigation controller
    val navController = rememberNavController()

    // Define all screens and their routes
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
                onMeditationClick = {
                    navController.navigate("med")
                },
                onResourcesClick = {
                    navController.navigate("resources")
                }
            )
        }

        // Mood Tracker screen
        composable("mood") {
            MoodScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onHistoryClick = {
                    // NEW: Open Mood History
                    navController.navigate("mood_history")
                }
            )
        }

        // NEW: Mood History screen
        composable("mood_history") {
            MoodHistoryScreen(
                onBackClick = {
                    // Go back to Mood Tracker
                    navController.popBackStack()
                }
            )
        }

        // Personal Journal screen
        composable("journal") {
            JournalScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // Guided Meditation screen
        composable("med") {
            MeditationScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onHistoryClick = {
                    // NEW: Open Meditation History
                    navController.navigate("meditation_history")
                }
            )
        }

        // NEW: Meditation History screen
        composable("meditation_history") {
            MeditationHistoryScreen(
                onBackClick = {
                    // Go back to Guided Meditation
                    navController.popBackStack()
                }
            )
        }

        // Wellbeing Resources screen
        composable("resources") {
            WellbeingResourcesScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
