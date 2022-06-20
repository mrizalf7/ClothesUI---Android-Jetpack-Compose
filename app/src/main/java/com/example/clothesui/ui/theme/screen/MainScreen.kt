package com.example.clothesui.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.clothesui.R
import com.example.clothesui.ui.theme.openSans

@Composable
fun MainScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFE5E5E5)
            )
    )
    {
//        Image(
//            painterResource(id = R.drawable.furee_logo), null,
//            modifier = Modifier.fillMaxSize()
//        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Button(
                navController = navController,
                title = "GetStartedScreen",
                route = "get_started_screen",
                color=0xFFFF4105
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(top = 155.dp)
            ) {
                Button(
                    navController = navController,
                    title = "HomeScreen",
                    route = "home_screen",
                    color = 0xFF28FF05
                )
                Button(
                    navController = navController,
                    title = "DetailScreen",
                    route = "detail_screen",
                    color = 0xFF07CAF4
                )

            }
        }
    }
}

@Composable
fun Button (navController:NavController, title:String, route:String, color: Long){

    Button(
        onClick = {
            navController.navigate(route)
        }, shape = CircleShape,
        colors = ButtonDefaults.buttonColors
            (
            Color(color)
        ),modifier=Modifier.width(200.dp).height(100.dp)
    ) {
        Text(
            title,
            fontFamily = openSans,
            color = Color.White,
            fontWeight = FontWeight(600),
            fontSize = 16.sp
        )
    }
}