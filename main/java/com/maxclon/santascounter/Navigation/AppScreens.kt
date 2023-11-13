package com.maxclon.santascounter.Navigation

sealed class AppScreens(val route: String) {
    object SplashScreenMaxclonIntro : AppScreens(route = "Splash MaxclonIntro Screen")
    object SplashScreenAppIntro : AppScreens(route = "Splash AppIntro Screen")
    object MainScreen : AppScreens(route = "Splash Main Screen")
}