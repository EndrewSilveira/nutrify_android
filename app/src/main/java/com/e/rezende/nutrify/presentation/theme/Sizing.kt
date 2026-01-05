package com.e.rezende.nutrify.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalSizing = staticCompositionLocalOf { Sizing() }

data class Sizing(
    val x1: Dp = 1.dp,
    val x2: Dp = 2.dp,
    val x9: Dp = 4.dp,
    val xSmall: Dp = 6.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val xLarge: Dp = 32.dp,
    val iconSize: Dp = 40.dp,
    val profileSizeSmall: Dp = 48.dp,
    val defaultImageSize: Dp = 60.dp,
    val x2l: Dp = 64.dp,
    val x3l: Dp = 128.dp,
    val x4l: Dp = 136.dp,
    val x5l: Dp = 150.dp,
    val x6l: Dp = 256.dp,
)
