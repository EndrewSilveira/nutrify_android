package com.e.rezende.nutrify.presentation.screen.home.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.domain.models.news.News
import com.e.rezende.nutrify.domain.models.news.NewsTags
import com.e.rezende.nutrify.presentation.base_components.WellnessNewsCard
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun WellnessNewsList(
    modifier: Modifier,
    items: List<News>
) {
    LazyRow(
        modifier = modifier,
    ) {
        items(count = items.size) { index ->
            WellnessNewsCard(
                news = items[index]
            )
        }
    }
}

@Preview
@Composable
private fun WellnessNewsListPreview() {
    NutrifyTheme {
        WellnessNewsList(
            modifier = Modifier,
            items = listOf(
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
            )
        )
    }
}