package com.exmple.investkraft.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exmple.investkraft.screen.LoginScreen
import com.exmple.investkraft.screen.OTPScreen
import com.exmple.investkraft.screen.SplashScreen
import com.exmple.investkraft.utils.Screen
import com.exmple.investkraft.viewmodel.AuthViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        // Splash Screen
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Login.route) {
            LoginScreen(
                viewModel = authViewModel,
                onNavigateToOTP = { mobile ->
                    navController.navigate(Screen.OTP.createRoute(mobile))
                }
            )
        }

        composable(
            route = Screen.OTP.route,
            arguments = listOf(navArgument("mobile") { type = NavType.StringType })
        ) { backStackEntry ->
            val mobile = backStackEntry.arguments?.getString("mobile") ?: ""
            OTPScreen(
                viewModel = authViewModel,
                mobile = mobile,
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.Home.route) {
            MainScreen()
        }
    }
}