package com.manishjajoriya.waterxcel.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manishjajoriya.waterxcel.R
import com.manishjajoriya.waterxcel.ui.theme.GreenSecondary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Page4(modifier: Modifier = Modifier, navigateFunction: (String) -> Unit) {
    var menuExpanded by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Use ModalNavigationDrawer to handle the drawer
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Add menu items in the drawer
            Column(modifier = Modifier.padding(16.dp)) {
                val menuItems = listOf("Home", "My Account", "Settings", "Help", "Logout")
                menuItems.forEach { item ->
                    Text(
                        text = item,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .clickable {
                                navigateFunction(item)
                                scope.launch {
                                    drawerState.close()  // Close the drawer after item click
                                }
                            },
                        fontSize = 18.sp
                    )
                }
            }
        }
    ) {
        // Scaffold to handle the rest of the UI
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("WasteXcel") },
                    navigationIcon = {
                        IconButton(onClick = {
                            // Toggle drawer state
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenSecondary,
                        titleContentColor = Color.White,
                        actionIconContentColor = Color.White
                    )
                )
            },
            content = { paddingValues ->
                // Rest of your content
                Column(modifier = modifier.fillMaxSize().padding(paddingValues)) {
                    Spacer(modifier = Modifier.height(16.dp))

                    // Profile Section
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
                                painter = painterResource(R.drawable.delhi_logo),
                                contentDescription = "Profile Picture",
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                            )
                            IconButton(
                                onClick = { /* Open Camera */ },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(Icons.Filled.CameraAlt, contentDescription = "Change Profile Picture")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Credit Tile
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable { navigateFunction("credits") },
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Box(modifier = Modifier.padding(16.dp)) {
                            Text("Current Credit: 1000 Points")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // WasteXcel Services
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("WasteXcel Services", fontSize = 20.sp)
                        val services = listOf("DMRC Metro", "LPG", "Solar Panel", "Electricity Discount")
                        services.forEach { service ->
                            Text(
                                text = service,
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .clickable { navigateFunction(service) },
                                fontSize = 18.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // Bottom Navigation
                    NavigationBar(
                        containerColor = GreenSecondary
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
                    }
                }
            }
        )
    }
}