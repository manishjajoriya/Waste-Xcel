package com.manishjajoriya.waterxcel.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun Page2(
    modifier: Modifier = Modifier,
    navigateFunctionTo4: () -> Unit,
    navigateFunctionTo3: () -> Unit,
    function: () -> Unit
) {
    var userId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var isLoggedIn by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) } // To toggle password visibility

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navigateFunctionTo3()
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Sign up")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Divider(modifier = Modifier.weight(1f), thickness = 1.dp)
                Text(" Or ", modifier = Modifier.padding(horizontal = 8.dp))
                Divider(modifier = Modifier.weight(1f), thickness = 1.dp)
            }

            Icon(Icons.Filled.Person, contentDescription = "Citizens", modifier = Modifier.size(48.dp))

            Text("Login", style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(16.dp))

            // User ID / Aadhar Number Input
            TextField(
                value = userId,
                onValueChange = { userId = it },
                label = { Text("User ID / Aadhar Number") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password Input
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                singleLine = true,
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            imageVector = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (showPassword) "Hide password" else "Show password"
                        )
                    }
                }
            )

            // Show Password Checkbox

            // Error message
            if (errorMessage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Login Button
            Button(
                onClick = {
                    // Validate credentials
//                    if (userId == "1234" && password == "1234") {
//                        // Navigate to 4th page if credentials are correct
//                        navigateFunction()
//                    } else {
//                        // Show error message if credentials are incorrect
//                        errorMessage = "Invalid User ID or Password. Please try again."
//                    }
                    navigateFunctionTo4()
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Login")
            }





            Spacer(modifier = Modifier.height(8.dp))

            // "Keep me logged in" Checkbox
            Row(verticalAlignment = Alignment.CenterVertically) {
                var checked by remember { mutableStateOf(false) }
                Checkbox(checked = checked, onCheckedChange = { checked = it })
                Text("Keep me logged in")
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Forgot Password Link
            TextButton(onClick = {
                // Handle forgot password logic here
            }) {
                Text("Forgot Password?")
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Admin Login? ")
                TextButton(
                    onClick = {
                        // Handle admin login click
                    },
                    contentPadding = PaddingValues(0.dp) // Removes extra padding
                ) {
                    Text(
                        "Click Here",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color(0xFF0077EE),
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }



            // Help Link
            TextButton(onClick = {
                // Handle help logic here
            }) {
                Text("Help")
            }
        }
    }
}
