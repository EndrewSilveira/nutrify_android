package com.e.rezende.nutrify.presentation.base_components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme
import kotlinx.coroutines.delay

@Composable
fun DefaultIconButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconResource:  Int,
    contentColor: Color? = null,
    @StringRes contentDescription: Int,
    targetScale: Float = 1.2f,
    defaultScale: Float = 1f,
    animationDuration: Int = 150,
    delayDuration: Long = 150L,
    onClick: () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) targetScale else defaultScale,
        animationSpec = tween(durationMillis = animationDuration)
    )

    LaunchedEffect(key1 = isPressed) {
        if (isPressed) {
            delay(delayDuration)
            isPressed = false
        }
    }

    IconButton(
        modifier = modifier
            .size(NutrifyTheme.sizing.iconSize),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            contentColor = contentColor ?: MaterialTheme.colorScheme.tertiary
        ),
        onClick = {
            isPressed = true
            onClick()
        }
    ) {
        Icon(
            modifier = Modifier
                .scale(scale),
            painter = painterResource(id = iconResource),
            contentDescription = stringResource(id = contentDescription),
        )
    }
}