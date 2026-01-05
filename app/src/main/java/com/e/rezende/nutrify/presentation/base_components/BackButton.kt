package com.e.rezende.nutrify.presentation.base_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    DefaultIconButton(
        modifier = modifier,
        iconResource = R.drawable.ic_arrow_left,
        contentDescription = R.string.back,
        onClick = onClick
    )
}

@Preview
@Composable
private fun BackButtonPreview() {
    NutrifyTheme {
        BackButton(onClick = {})
    }
}