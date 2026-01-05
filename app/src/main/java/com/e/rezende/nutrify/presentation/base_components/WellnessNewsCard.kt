package com.e.rezende.nutrify.presentation.base_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.domain.models.news.News
import com.e.rezende.nutrify.domain.models.news.NewsTags
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun WellnessNewsCard(
    modifier: Modifier = Modifier,
    news: News
) {
    Column(
        modifier = modifier
            .width(NutrifyTheme.sizing.x5l)
            .background(MaterialTheme.colorScheme.surface)
            .padding(NutrifyTheme.sizing.small),
        verticalArrangement = Arrangement.spacedBy(NutrifyTheme.sizing.x2),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(NutrifyTheme.sizing.medium)),
            painter = painterResource(id = news.imageResource),
            contentDescription = "Card News",
            contentScale = ContentScale.Crop
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = NutrifyTheme.sizing.small),
            horizontalArrangement = Arrangement.spacedBy(NutrifyTheme.sizing.xSmall)
        ) {
            items(count = news.tags.size) {
                Text(
                    modifier = Modifier
                        .border(
                            width = NutrifyTheme.sizing.x1,
                            color = MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(size = NutrifyTheme.sizing.x9)
                        )
                        .padding(horizontal = NutrifyTheme.sizing.small),
                    text = stringResource(news.tags[it].stringResourceId),
                    style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.tertiary)
                )
            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = NutrifyTheme.sizing.xSmall),
            text = news.description,
            maxLines = 3,
            minLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.tertiary)
        )

        Text(
            text = stringResource(
                R.string.reading_time,
                news.readingTime.milliseconds.inWholeMilliseconds
            ),
            style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.tertiaryFixed),
        )
    }

}

@Preview
@Composable
private fun WellnessNewsCardPreview() {
    NutrifyTheme {
        WellnessNewsCard(
            modifier = Modifier.width(NutrifyTheme.sizing.x5l),
            news = News(
                description = "Lorem ipsum dolor sit amet consectetur adipiscing elit.",
                tags = listOf(NewsTags.WELL_BEING, NewsTags.NUTRITION),
                imageResource = R.drawable.img_nutritional_news_3,
                readingTime = 125000
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WellnessNewsCardListPreview() {
    NutrifyTheme {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(NutrifyTheme.sizing.small)
        ) {
            items(count = 3) {
                WellnessNewsCard(
                    modifier = Modifier.width(NutrifyTheme.sizing.x5l),
                    news = News(
                        description = "Lorem ipsum dolor sit amet consectetur adipiscing elit ipsum dolor sit amet consectetur adipiscing elit.",
                        tags = listOf(NewsTags.WELL_BEING, NewsTags.NUTRITION),
                        imageResource = R.drawable.img_nutritional_news_3,
                        readingTime = 300000L
                    )
                )
            }
        }
    }
}