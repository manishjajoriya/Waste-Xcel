package com.manishjajoriya.waterxcel.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manishjajoriya.waterxcel.ui.theme.GreenPrimary
import com.manishjajoriya.waterxcel.ui.theme.GreenSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier, navigateFunction: (String) -> Unit){
    var menuExpanded by remember { mutableStateOf(false) }

    val menuItems = listOf("Home", "My Account", "Settings", "Help", "Logout")

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
                            when (item) {
                                "Home" -> navigateFunction("home")
                                "My Account" -> navigateFunction("my_account")
                                "Settings" -> navigateFunction("settings")
                                "Help" -> navigateFunction("help")
                                "Logout" -> navigateFunction("logout")
                            }
                            navigateFunction(item)
                            menuExpanded = false // Close menu after item click
                        },
                        text = { Text(text = item) }
                    )
                }
            }
        }
    )
}


