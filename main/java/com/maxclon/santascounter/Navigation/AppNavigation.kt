package com.maxclon.santascounter.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxclon.santascounter.MainScreen
import com.maxclon.santascounter.SplashScreenAppIntro
import com.maxclon.santascounter.SplashScreenMaxclonIntro

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreenMaxclonIntro.route
    ) {
        composable(AppScreens.SplashScreenMaxclonIntro.route) {
            SplashScreenMaxclonIntro(
                navController
            )
        }
        composable(AppScreens.SplashScreenAppIntro.route) { SplashScreenAppIntro(navController) }
        composable(AppScreens.MainScreen.route) { MainScreen(navController) }

    }
}