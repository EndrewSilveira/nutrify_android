package com.e.rezende.nutrify.presentation.base_components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    onClick: (isSelected: Boolean) -> Unit
) {
    var isSelected by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.tertiary,
        animationSpec = tween(durationMillis = 100)
    )

    DefaultIconButton(
        modifier = modifier,
        iconResource = if (isSelected) R.drawable.ic_heart_filled else R.drawable.ic_heart,
        contentColor = color,
        contentDescription = R.string.favorite_button,
        animationDuration = 500,
        onClick = {
            isSelected = !isSelected
            onClick(isSelected)
        }
    )
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    NutrifyTheme {
        FavoriteButton {}
    }
}