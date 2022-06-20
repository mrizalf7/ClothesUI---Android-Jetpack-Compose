package com.example.clothesui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.clothesui.ui.theme.ClothesUITheme
import com.example.clothesui.ui.theme.screen.DetailScreen
import com.example.clothesui.ui.theme.screen.GetStartedScreen
import com.example.clothesui.ui.theme.screen.HomeScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClothesUITheme {
                Navigation()
            }
        }
    }
}