package com.e.rezende.nutrify.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.domain.models.ingredients.Ingredient
import com.e.rezende.nutrify.domain.models.news.News
import com.e.rezende.nutrify.domain.models.news.NewsTags
import com.e.rezende.nutrify.domain.models.recipe.Recipe
import com.e.rezende.nutrify.presentation.base_components.ProfileAppbar
import com.e.rezende.nutrify.presentation.base_components.TitledSection
import com.e.rezende.nutrify.presentation.screen.home.components.HealthyRecipeList
import com.e.rezende.nutrify.presentation.screen.home.components.WellnessNewsList
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val mockedNewsList = listOf(
        News(
            description = "5 Tips for a Healthier Lifestyle",
            imageResource = R.drawable.img_nutritional_news_2,
            tags = listOf(
                NewsTags.NUTRITION
            )
        ),
        News(
            description = "The Benefits of Regular Exercise",
            imageResource = R.drawable.img_nutritional_news_2,
            tags = listOf(
                NewsTags.NUTRITION
            )
        ),
        News(
            description = "Healthy Eating Habits for a Better You",
            imageResource = R.drawable.img_nutritional_news_2,
            tags = listOf(
                NewsTags.NUTRITION
            )
        ),
    )

    val mockedRecipes = listOf(
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

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            ProfileAppbar(
                profilePicture = R.drawable.img_nutritional_news_1,
                userName = "Endrew",
                hasUnreadNotification = true,
                onProfileClick = { },
                onNotificationClick = { }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TitledSection(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(R.string.health_in_focus)
            ) {
                WellnessNewsList(
                    modifier = Modifier.fillMaxWidth(),
                    items = mockedNewsList
                )
            }

            TitledSection(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.onSurfaceVariant),
                title = stringResource(R.string.nutritional_table)
            ) {
                HealthyRecipeList(
                    modifier = Modifier.fillMaxWidth(),
                    recipes = mockedRecipes
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    NutrifyTheme {
        HomeScreen()
    }
}