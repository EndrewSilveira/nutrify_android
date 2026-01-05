package com.e.rezende.nutrify.presentation.base_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.presentation.screen.home.components.HealthyRecipeList
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun TitledSection(
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .padding(vertical = NutrifyTheme.sizing.medium),
        verticalArrangement = Arrangement.spacedBy(NutrifyTheme.sizing.small)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = NutrifyTheme.sizing.small),
            text = title,
            style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.tertiary)
        )

        content()
    }
}