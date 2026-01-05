package com.e.rezende.nutrify.presentation.screen.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.domain.models.ingredients.Ingredient
import com.e.rezende.nutrify.domain.models.recipe.Recipe
import com.e.rezende.nutrify.presentation.base_components.HealthyRecipeCard
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun HealthyRecipeList(
    modifier: Modifier = Modifier,
    recipes: List<Recipe>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(recipes.size, key = {recipes[it].id }) { index ->
            val recipe = recipes[index]
            HealthyRecipeCard(recipe = recipe)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HealthyRecipeListPreview() {
    NutrifyTheme{
        HealthyRecipeList(
            modifier = Modifier.fillMaxWidth(),
            recipes = listOf(
                Recipe(
                    title = "Asserted Salad",
                    imageResource = R.drawable.img_assorted_salad,
                    calories = 250.0,
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
                ),
                Recipe(
                    title = "Grilled Chicken",
                    imageResource = R.drawable.img_grilled_chicken,
                    calories = 300.0,
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
                ),
                Recipe(
                    title = "Grilled Tofu",
                    imageResource = R.drawable.img_grilled_tofu,
                    calories = 400.0,
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
        )
    }
}