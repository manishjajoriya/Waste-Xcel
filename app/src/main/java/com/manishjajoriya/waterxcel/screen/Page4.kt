package com.manishjajoriya.waterxcel.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manishjajoriya.waterxcel.R
import androidx.compose.material3.ButtonDefaults
import com.manishjajoriya.waterxcel.ui.theme.GreenSecondary
import com.manishjajoriya.waterxcel.ui.theme.GreenPrimary

import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Page4(modifier: Modifier = Modifier, navigateFunction: (String) -> Unit) {
    var menuExpanded by remember { mutableStateOf(false) }

    // Menu Items for drop-down
    val menuItems = listOf("Home", "My Account", "Settings","Notification", "Help", "Logout")

    // Top App Bar with a dropdown menu for the hamburger button
    Column {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start, // Align title and icon to the start (left)
                ) {
                    IconButton(onClick = { menuExpanded = !menuExpanded }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = GreenPrimary)
                    }
                    Spacer(modifier = Modifier.width(8.dp)) // Optional space between icon and title
                    Text("WasteXcel", color = Color.White, fontSize = 20.sp) // Title
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = GreenSecondary,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            modifier = Modifier.height(100.dp),
            actions = {
                // Dropdown Menu positioned below the menu button
                DropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false },
                    modifier = Modifier.fillMaxWidth() // Adjust the width if needed
                ) {
                    menuItems.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                // Navigate to the corresponding page
                                when (item) {
                                    "Home" -> navigateFunction("home")
                                    "My Account" -> navigateFunction("myAccount")
                                    "Settings" -> navigateFunction("settings")
                                    "Help" -> navigateFunction("help")
                                    "Logout" -> navigateFunction("logout")
                                }
                                menuExpanded = false // Close menu after item click
                            },
                            text = { Text(text = item) }
                        )
                    }
                }
            }
        )

        // Main Content
        Column(modifier = Modifier.fillMaxSize()) {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Welcome, Manish", fontSize = 24.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("User ID: 1234")
                        Text("Linked Aadhar Card: XXXX XXXX 1234")
                    }
                    Box(contentAlignment = Alignment.BottomEnd) {
                        Image(
                            painter = painterResource(R.drawable.profile),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                        )
                        IconButton(
                            onClick = { /* Open Camera */ },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                Icons.Filled.CameraAlt,
                                contentDescription = "Change Profile Picture"
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Your Credit Card Section
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable { navigateFunction("credits") },
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Box(modifier = Modifier.padding(16.dp)) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Your Credit",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Text(
                                text = "Current Credit: 100 Points",
                                fontSize = 16.sp,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            Button(
                                onClick = { navigateFunction("Credit") },
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(text = "View My Credit")
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Redeem Services (unchanged)
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Redeem Services",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    val services =
                        listOf("DMRC Metro", "LPG", "Solar Panel", "Electricity Discount")

                    Column(modifier = Modifier.fillMaxWidth()) {
                        // First Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // First button
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp)
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                GreenPrimary,
                                                GreenSecondary
                                            )
                                        ), shape = RoundedCornerShape(12.dp)
                                    )
                                    .padding(4.dp),
                                shape = RoundedCornerShape(12.dp),
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.delhi_metro),
                                    contentDescription = "Delhi Metro",
                                    modifier = Modifier.size(36.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = services[0],
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.White
                                )
                            }

                            // Second button
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp)
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                GreenPrimary,
                                                GreenSecondary
                                            )
                                        ), shape = RoundedCornerShape(12.dp)
                                    )
                                    .padding(4.dp),
                                shape = RoundedCornerShape(12.dp),
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.gas),
                                    contentDescription = "LPG Cylinder",
                                    modifier = Modifier.size(48.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = services[1],
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Second Row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Third button
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp)
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                GreenPrimary,
                                                GreenSecondary
                                            )
                                        ), shape = RoundedCornerShape(12.dp)
                                    )
                                    .padding(4.dp),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.solar_panel),
                                    contentDescription = "Solar Panel",
                                    modifier = Modifier.size(48.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = services[2],
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.White
                                )
                            }

                            // Fourth button
                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp)
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                GreenPrimary,
                                                GreenSecondary
                                            )
                                        ), shape = RoundedCornerShape(12.dp)
                                    )
                                    .padding(4.dp),
                                shape = RoundedCornerShape(12.dp),
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.lightning),
                                    contentDescription = "Electricity Discount",
                                    modifier = Modifier.size(28.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = services[3],
                                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 19.sp),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
                Button(
                    onClick = { navigateFunction("Track Truck Location") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = 16.dp) // Horizontal padding to avoid edge-to-edge
                        .background(
                            Brush.verticalGradient(listOf(GreenPrimary, GreenSecondary)),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(4.dp), // Padding inside the button
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Transparent to keep gradient
                ) {
                    Image(
                        painter = painterResource(R.drawable.garbage_truck),
                        contentDescription = "Track Truck Location",
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Track Truck Location",
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 19.sp),
                        color = Color.White
                    )
                }

            }

            Spacer(modifier = Modifier.weight(1f))

            // Bottom Navigation
            NavigationBar(
                containerColor = GreenSecondary,
                modifier = Modifier.fillMaxWidth() // Full width
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    selected = false,
                    onClick = { navigateFunction("home") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.CameraAlt, contentDescription = "Camera") },
                    selected = false,
                    onClick = { navigateFunction("camera") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                    selected = false,
                    onClick = { navigateFunction("search") }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Filled.CurrencyExchange, contentDescription = "Credit") },
                    selected = false,
                    onClick = { navigateFunction("Credit") }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Filled.QuestionMark, contentDescription = "FAQ") },
                    selected = false,
                    onClick = { navigateFunction("FAQ") }
                )
            }
        }
    }
}


