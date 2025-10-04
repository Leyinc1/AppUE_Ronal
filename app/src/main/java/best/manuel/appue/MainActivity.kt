package best.manuel.appue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import best.manuel.appue.presentation.navigation.AppNavGraph
import best.manuel.appue.presentation.navigation.AppScreens
import best.manuel.appue.ui.theme.AppUETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppUETheme {
                val navController = rememberNavController()
                AppNavGraph(
                    navController = navController,
                    startDestination = AppScreens.REGISTER_ROUTE // Iniciar en Registro
                )
            }
        }
    }
}