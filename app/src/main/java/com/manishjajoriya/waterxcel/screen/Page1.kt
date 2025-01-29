package com.manishjajoriya.waterxcel.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.manishjajoriya.waterxcel.R


@Composable
fun Page1(modifier: Modifier = Modifier, navigateFunction:() -> Unit) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    Box(modifier = modifier) {

        Column(
            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))
            Row {
                Image(
                    painter = painterResource(R.drawable.delhi_logo),
                    contentDescription = "Delhi Government Logo",
                    modifier = Modifier.size(140.dp)
                )

                Image(
                    painter = painterResource(R.drawable.viksit_bharat),
                    contentDescription = "Delhi Government Logo",
                    modifier = Modifier.size(140.dp)
                )
            }
            Spacer(modifier = Modifier.height(70.dp))
            Text("Waste Xcel", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(20.dp))


            Row() {
                Button(
                    onClick = navigateFunction,
                    modifier = Modifier
                        .width((screenWidth * 0.4).dp)
                        .height((screenHeight * 0.2).dp)
                        .padding(8.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(12.dp)),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface)
                ) {
                    Column( modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Filled.Person, contentDescription = "Citizens", modifier = Modifier.size(32.dp))
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Citizens", style = MaterialTheme.typography.titleMedium)
                    }

                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width((screenWidth * 0.4).dp)
                        .height((screenHeight * 0.2).dp)
                        .padding(8.dp)
                        .shadow(8.dp, shape = RoundedCornerShape(12.dp)),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface)
                ) {
                    Column( modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Filled.Build, contentDescription = "Citizens", modifier = Modifier.size(32.dp))
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Staff", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
            Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxHeight()) {
                Text("Designed By Team Shunya")
            }
        }

    }
}



