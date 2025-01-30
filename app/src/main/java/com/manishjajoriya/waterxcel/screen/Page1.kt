package com.manishjajoriya.waterxcel.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manishjajoriya.waterxcel.R
import com.manishjajoriya.waterxcel.ui.theme.SerifFont
import kotlinx.coroutines.delay


@Composable
fun Page1(modifier: Modifier = Modifier, navigateFunction:() -> Unit) {

    LaunchedEffect(Unit) {
        delay(2000)
        navigateFunction()
    }

    Box(modifier = modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.delhi_logo),
                    contentDescription = "Delhi Government Logo",
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier =Modifier.width(8.dp))
                Image(
                    painter = painterResource(R.drawable.viksit_bharat),
                    contentDescription = "Viksit Bharat 2047 Logo",
                    modifier = Modifier.size(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(70.dp))
            Text("Welcome To", style = MaterialTheme.typography.titleLarge.copy(fontFamily = SerifFont))
            Text("WasteXcel", style = MaterialTheme.typography.titleLarge.copy(fontSize = 36.sp))
            Spacer(modifier = Modifier.height(20.dp))


//            Row() {
//                Button(
//                    onClick = navigateFunction,
//                    modifier = Modifier
//                        .width((screenWidth * 0.4).dp)
//                        .height((screenHeight * 0.2).dp)
//                        .padding(8.dp)
//                        .shadow(8.dp, shape = RoundedCornerShape(12.dp)),
//                    shape = RoundedCornerShape(12.dp),
//                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface)
//                ) {
//                    Column( modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally) {
//                        Icon(Icons.Filled.Person, contentDescription = "CITIZENS", modifier = Modifier.size(32.dp))
//                        Spacer(modifier = Modifier.height(4.dp))
//                        Text("CITIZENS", style = MaterialTheme.typography.titleMedium.copy(letterSpacing = 0.4.sp))
//                    }
//
//                }
//                Spacer(modifier = Modifier.width(5.dp))
//                Button(
//                    onClick = {},
//                    modifier = Modifier
//                        .width((screenWidth * 0.4).dp)
//                        .height((screenHeight * 0.2).dp)
//                        .padding(8.dp)
//                        .shadow(8.dp, shape = RoundedCornerShape(12.dp)),
//                    shape = RoundedCornerShape(12.dp),
//                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface)
//                ) {
//                    Column( modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally) {
//                        Icon(Icons.Filled.Build, contentDescription = "STAFF", modifier = Modifier.size(32.dp))
//                        Spacer(modifier = Modifier.height(4.dp))
//                        Text("STAFF", style = MaterialTheme.typography.titleMedium.copy(letterSpacing = 0.4.sp))
//                    }
//                }
//            }
            Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxHeight()) {
                Text("Designed By Team Shunya")
            }
        }

    }
}



