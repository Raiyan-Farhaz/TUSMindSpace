
package com.example.tusmindspace.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tusmindspace.R

// Creates the Wellbeing Resources screen
@Composable
fun WellbeingResourcesScreen(onBackClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Back arrow and screen title
        Row(
            modifier = Modifier.fillMaxWidth(),
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

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = "Well Being Resources",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Location icon from drawable folder
        Image(
            painter = painterResource(id = R.drawable.location),
            contentDescription = "Location icon",
            modifier = Modifier.size(55.dp)
        )

        Spacer(modifier = Modifier.height(22.dp))

        // Description
        Text(
            text = "Find nearby support services at TUS and in Limerick.",
            fontSize = 15.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Temporary map placeholder
        // Google Maps will be added later
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .background(
                    Color(0xFFE5E5E5),
                    RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Google Maps will appear here",
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier.height(55.dp))

        // TUS Student Support button
        Button(
            onClick = {
                // Later: Open TUS Student Support
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD9D9D9),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("TUS Student Support       →")
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Counselling Services button
        Button(
            onClick = {
                // Later: Open counselling contact
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD9D9D9),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("Counselling Services       →")
        }
    }
}
