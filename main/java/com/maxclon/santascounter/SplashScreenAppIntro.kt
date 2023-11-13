package com.maxclon.santascounter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.maxclon.santascounter.Navigation.AppScreens
import com.maxclon.santascounter.loadscreenappintro.LoadScreenAppIntro
import kotlinx.coroutines.delay

@Composable
fun SplashScreenAppIntro(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.popBackStack()
        navController.navigate(AppScreens.MainScreen.route)
    }

    LoadScreenAppIntro()


}

@Preview(showSystemUi = true)
@Composable
fun PreviewSplashScreenAppIntro() {
    LoadScreenAppIntro()


}


