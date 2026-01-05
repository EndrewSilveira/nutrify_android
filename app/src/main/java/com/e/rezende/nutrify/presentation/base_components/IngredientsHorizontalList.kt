package com.e.rezende.nutrify.presentation.base_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.domain.models.recipe.Recipe
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun IngredientsHorizontalList(
    modifier: Modifier = Modifier,
    recipe: Recipe
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(space = NutrifyTheme.sizing.x9)
    ) {
        items(
            recipe.ingredients.size,
            key = { index -> recipe.ingredients[index].name }) { index ->
            val ingredientsNameResource = if (recipe.ingredients.lastIndex == index) {
                R.string.ingredients_value
            } else {
                R.string.multiple_ingredients_value
            }

            Text(
                text = stringResource(
                    id = ingredientsNameResource,
                    recipe.ingredients[index].quantity,
                    recipe.ingredients[index].name
                ),
                style = MaterialTheme.typography.bodyMedium
                    .copy(color = MaterialTheme.colorScheme.tertiaryFixed),
            )
        }
    }
}