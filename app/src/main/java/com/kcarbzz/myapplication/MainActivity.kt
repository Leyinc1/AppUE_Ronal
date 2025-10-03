package com.kcarbzz.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.kcarbzz.myapplication.presentation.navigation.AppNavGraph
import com.kcarbzz.myapplication.presentation.navigation.AppScreens
import com.kcarbzz.myapplication.ui.theme.AppUETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppUETheme {
                val navController = rememberNavController()
                AppNavGraph(
                    navController = navController,
                    startDestination = AppScreens.REGISTER_ROUTE
                )
            }
        }
    }
}