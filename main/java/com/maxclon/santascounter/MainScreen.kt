package com.maxclon.santascounter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.maxclon.santascounter.appmain.AppMain
import com.maxclon.santascounter.loadscreenappintro.milonga
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import kotlin.time.Duration.Companion.seconds

@Composable
fun MainScreen(navController: NavHostController) {

    CountdownToChristmasEve()

    AppMain()


}

@Composable
fun CountdownToChristmasEve() {
    val zone = ZoneId.systemDefault()
    var timeUntilChristmasEve by remember { mutableStateOf(calculateTimeUntilChristmasEve(zone)) }

    LaunchedEffect(true) {
        val updateInterval = 1.seconds.inWholeMilliseconds // Actualiza cada 1 segundo

        while (true) {
            delay(updateInterval)
            timeUntilChristmasEve = calculateTimeUntilChristmasEve(zone)
        }
    }

    val days = timeUntilChristmasEve / (60 * 60 * 24)
    val hours = (timeUntilChristmasEve % (60 * 60 * 24)) / (60 * 60)
    val minutes = (timeUntilChristmasEve % (60 * 60)) / 60
    val seconds = timeUntilChristmasEve % 60

    Text(
        text = "$days Days : $hours Hours : $minutes Minutes : $seconds Seconds",
        color = Color.Red,
        fontFamily = milonga,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 240.dp)
            .zIndex(1f),
        textAlign = TextAlign.Center
    )
}

private fun calculateTimeUntilChristmasEve(zone: ZoneId): Long {
    val currentTime = LocalDateTime.now(zone)
    val christmasEve = LocalDateTime.of(currentTime.year, Month.DECEMBER, 24, 0, 0).atZone(zone)
    return ChronoUnit.SECONDS.between(currentTime, christmasEve)
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    Box() {

        AppMain()
        CountdownToChristmasEve()
    }
}


