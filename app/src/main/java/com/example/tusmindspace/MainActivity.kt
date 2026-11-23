
package com.example.tusmindspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

// Navigation imports
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Room Database imports
import androidx.room.Room
import com.example.tusmindspace.database.AppDatabase

// ViewModel imports
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tusmindspace.viewmodel.MoodViewModel
import com.example.tusmindspace.viewmodel.JournalViewModel

// Import screens
import com.example.tusmindspace.screens.HomeScreen
import com.example.tusmindspace.screens.MoodScreen
import com.example.tusmindspace.screens.JournalScreen
import com.example.tusmindspace.screens.MeditationScreen
import com.example.tusmindspace.screens.WellbeingResourcesScreen

// Import history screens
import com.example.tusmindspace.screens.MoodHistoryScreen
import com.example.tusmindspace.screens.JournalHistoryScreen
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

    // Get application context
    val context = LocalContext.current.applicationContext

    // Create or open the Room Database
    val database = remember {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "tusmindspace_database"
        )
            // Allow database recreation when version changes
            .fallbackToDestructiveMigration(true)
            .build()
    }

    // Create MoodViewModel and connect it to MoodDao
    val moodViewModel: MoodViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>
            ): T {
                return MoodViewModel(database.moodDao()) as T
            }
        }
    )

    // Create JournalViewModel and connect it to JournalDao
    val journalViewModel: JournalViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>
            ): T {
                return JournalViewModel(database.journalDao()) as T
            }
        }
    )

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
                    // Open Mood History
                    navController.navigate("mood_history")
                },
                moodViewModel = moodViewModel
            )
        }

        // Mood History screen
        composable("mood_history") {
            MoodHistoryScreen(
                onBackClick = {
                    // Go back to Mood Tracker
                    navController.popBackStack()
                },
                moodViewModel = moodViewModel
            )
        }

        // Personal Journal screen
        composable("journal") {
            JournalScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onHistoryClick = {
                    // Open Journal History
                    navController.navigate("journal_history")
                },
                journalViewModel = journalViewModel
            )
        }

        // Journal History screen
        composable("journal_history") {
            JournalHistoryScreen(
                onBackClick = {
                    // Go back to Personal Journal
                    navController.popBackStack()
                },
                journalViewModel = journalViewModel
            )
        }

        // Guided Meditation screen
        composable("med") {
            MeditationScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onHistoryClick = {
                    // Open Meditation History
                    navController.navigate("meditation_history")
                }
            )
        }

        // Meditation History screen
        composable("meditation_history") {
            MeditationHistoryScreen(
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
