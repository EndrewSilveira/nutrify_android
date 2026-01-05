package com.e.rezende.nutrify.presentation.base_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.domain.models.ingredients.Ingredient
import com.e.rezende.nutrify.domain.models.recipe.Recipe
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun HealthyRecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .padding(NutrifyTheme.sizing.small)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(NutrifyTheme.sizing.defaultImageSize)
                    .clip(RoundedCornerShape(NutrifyTheme.sizing.medium)),
                painter = painterResource(id = recipe.imageResource),
                contentDescription = "Card News",
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(NutrifyTheme.sizing.small),
                verticalArrangement = Arrangement.spacedBy(space = NutrifyTheme.sizing.small)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.headlineMedium
                            .copy(color = MaterialTheme.colorScheme.tertiary),
                    )
                    Text(
                        text = stringResource(id = R.string.calories_value, recipe.calories),
                        style = MaterialTheme.typography.titleSmall
                            .copy(color = MaterialTheme.colorScheme.tertiary),
                    )
                }

                IngredientsHorizontalList(recipe = recipe)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HealthyRecipeCardPreview() {
    NutrifyTheme {
        HealthyRecipeCard(
            recipe = Recipe(
                title = "Salada variada",
                imageResource = R.drawable.img_assorted_salad,
                calories = 221.15,
                ingredients = listOf(
                    Ingredient(
                        name = "proteina",
                        quantity = 18.40
                    ),
                    Ingredient(
                        name = "carboidrato",
                        quantity = 20.87
                    ),
                )
            )
        )
    }
}