
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

