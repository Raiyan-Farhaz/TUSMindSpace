
package com.example.tusmindspace.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tusmindspace.viewmodel.JournalViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Screen that displays saved journal entries
@Composable
fun JournalHistoryScreen(
    onBackClick: () -> Unit,
    journalViewModel: JournalViewModel
) {

    // Get all saved journals from Room Database
    val journals by journalViewModel.allJournals.collectAsState(
        initial = emptyList()
    )

    // Format saved timestamps into readable dates
    val dateFormat = remember {
        SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        // Top row: back arrow and title
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

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
                text = "Journal History",
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Check whether journal entries exist
        if (journals.isEmpty()) {

            Text(
                text = "No journal entries saved yet.",
                fontSize = 15.sp,
                color = Color.Gray
            )

        } else {

            // Display saved journal entries in a scrollable list
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(journals) { journal ->

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Color(0xFFF0EAF8),
                                RoundedCornerShape(8.dp)
                            )
                            .padding(16.dp)
                    ) {

                        // Display date and time
                        Text(
                            text = dateFormat.format(Date(journal.date)),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF673AB7)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Display saved journal text
                        Text(
                            text = journal.content,
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}
