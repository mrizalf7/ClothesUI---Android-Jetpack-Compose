package com.example.clothesui.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.clothesui.R
import com.example.clothesui.ui.theme.*

@Composable
fun GetStartedScreen(navController:NavController) {

    Box(
        modifier = Modifier
            .background(GreyBlueBackground)
            .fillMaxSize()
    )
    {
        Image(
            painterResource(R.drawable.model_clothes_home), contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 45.dp, vertical = 25.dp)
                .width(400.dp)
                .height(275.dp)
                .align(Alignment.BottomCenter)
                .background(WhiteBackground, RoundedCornerShape(30.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Find your best outfit and look great",
                    Modifier.padding(top = 25.dp, end = 25.dp, start = 25.dp), style =
                    MaterialTheme.typography.h1, textAlign = TextAlign.Center, lineHeight = 35.sp
                )
                Text(
                    text = "Shop here and get benefits and world quality goods",
                    Modifier.padding(top = 10.dp, end = 25.dp, start = 25.dp),
                    textAlign = TextAlign.Center, style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.W600, lineHeight = 23.sp, fontSize = 16.sp,
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(7.dp),
                    modifier = Modifier
                        .padding(top = 18.dp)
                )
                {
                    Box(
                        modifier = Modifier
                            .background(CircleBlueButton, RoundedCornerShape(50))
                            .size(7.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(CircleGrayButton, RoundedCornerShape(50))
                            .size(7.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(CircleGrayButton, RoundedCornerShape(50))
                            .size(7.dp)
                    )
                }
                Box(
                    modifier = Modifier.padding(top = 30.dp)
                        .clickable {
                            navController.navigate("home_screen")
                        }
                ) {

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(BlueButtonStart, RoundedCornerShape(30.dp))
                            .width(225.dp)
                            .height(40.dp)

                    )
                    {
                        Text(
                            "Get Started", style = MaterialTheme.typography.body1,
                            color = Color.White, fontWeight = FontWeight.W400, fontSize = 12.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}


