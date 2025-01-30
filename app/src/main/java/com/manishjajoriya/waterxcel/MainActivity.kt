package com.manishjajoriya.waterxcel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.manishjajoriya.waterxcel.screen.Page1
import com.manishjajoriya.waterxcel.screens.Page2
import com.manishjajoriya.waterxcel.screens.Page3
import com.manishjajoriya.waterxcel.screens.Page4
import com.manishjajoriya.waterxcel.ui.theme.WaterXcelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterXcelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationGraph(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    // Define the navigation graph
    NavHost(navController = navController, startDestination = "page1") {
        composable("page1") {
            // Pass navigation function to Page1
            Page1(modifier = modifier) { navController.navigate("page2") }
        }
        composable("page2") {
            // You can pass navigateFunction here as well if needed
            Page2(
                modifier = modifier,
                navigateFunctionTo4 = { navController.navigate("page4") },
                navigateFunctionTo3 = { navController.navigate("page3") }
            ) { }
        }

        composable("page3") {
            // You can pass navigateFunction here as well if needed
            Page3(modifier = modifier) { navController.navigate("page4") }
        }

        composable("page4") {
            Page4(modifier = Modifier) { }
        }
    }

}