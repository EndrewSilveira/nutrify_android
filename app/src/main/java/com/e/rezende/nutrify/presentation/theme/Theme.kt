package com.e.rezende.nutrify.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    surface = Surface,
    onSurface = SurfaceElement,
    background = Background,
    tertiary = TextPrimary,
    tertiaryFixed = TextSecondary,
    onSurfaceVariant = SurfaceVariant
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    surface = Surface,
    onSurface = SurfaceElement,
    background = Background,
    tertiary = TextPrimary,
    tertiaryFixed = TextSecondary,
    onSurfaceVariant = SurfaceVariant
)

@Composable
fun NutrifyTheme(
    sizing: Sizing = Sizing(),
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = {
            CompositionLocalProvider(
                LocalSizing provides sizing
            ) {
                content()
            }
        }
    )
}

object NutrifyTheme {
    val sizing: Sizing
        @Composable
        get() = LocalSizing.current
}