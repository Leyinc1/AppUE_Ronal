package best.manuel.appue.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// Importa las pantallas
import best.manuel.appue.presentation.auth.LoginScreen
import best.manuel.appue.presentation.auth.RegisterScreen
import best.manuel.appue.presentation.home.PlaylistScreen

// 1. Rutas de la Aplicación
object AppScreens {
    const val LOGIN_ROUTE = "login_route"
    const val REGISTER_ROUTE = "register_route" // Ruta para el registro
    const val HOME_ROUTE = "home_route"
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String // La ruta inicial
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        // === Ruta de Login ===
        composable(route = AppScreens.LOGIN_ROUTE) {
            LoginScreen(
                onSuccessfulLogin = {
                    navController.navigate(AppScreens.HOME_ROUTE) {
                        popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(AppScreens.REGISTER_ROUTE)
                }
            )
        }

        // === Ruta de Registro ===
        composable(route = AppScreens.REGISTER_ROUTE) {
            RegisterScreen(
                onSuccessfulRegister = {
                    navController.navigate(AppScreens.HOME_ROUTE) {
                        popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(AppScreens.LOGIN_ROUTE)
                }
            )
        }

        // === Ruta Home ===
        composable(route = AppScreens.HOME_ROUTE) {
            PlaylistScreen()
        }
    }
}