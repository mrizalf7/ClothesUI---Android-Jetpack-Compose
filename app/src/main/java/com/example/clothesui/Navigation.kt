package com.example.clothesui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clothesui.ui.theme.screen.DetailScreen
import com.example.clothesui.ui.theme.screen.GetStartedScreen
import com.example.clothesui.ui.theme.screen.HomeScreen
import com.example.clothesui.ui.theme.screen.MainScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController =navController,startDestination = "main_screen" ){
        //Navigation Declaration
        composable(route = "main_screen"){
            MainScreen(navController)
        }
        composable("get_started_screen"){
            GetStartedScreen(navController)
        }
        composable("home_screen"){
            HomeScreen()
        }
        composable("detail_screen"){
            DetailScreen()
        }
    }
}
