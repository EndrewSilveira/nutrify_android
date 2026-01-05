package com.e.rezende.nutrify.presentation.base_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.e.rezende.nutrify.R
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme
import com.e.rezende.nutrify.presentation.theme.Secondary

private const val NOTIFICATION_BADGE_OUTER_CIRCLE_RATIO = 7f
private const val NOTIFICATION_BADGE_INNER_CIRCLE_RATIO = 1.5f
private const val NOTIFICATION_BADGE_OFFSET_X_RATIO = 0.7f
private const val NOTIFICATION_BADGE_OFFSET_Y_RATIO = 0.2f

@Composable
fun ProfileAppbar(
    modifier: Modifier = Modifier,
    profilePicture: Int,
    userName: String,
    hasUnreadNotification: Boolean = false,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit
) {
    var hasUnreadNotification by remember { mutableStateOf(hasUnreadNotification) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = modifier
                .padding(
                    horizontal = NutrifyTheme.sizing.small,
                    vertical = NutrifyTheme.sizing.large
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(NutrifyTheme.sizing.profileSizeSmall)
                    .clip(CircleShape)
                    .clickable(onClick = { onProfileClick }),
                painter = painterResource(id = profilePicture),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(NutrifyTheme.sizing.small),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.hello_title, userName),
                    style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.tertiary),
                )
                Text(
                    text = stringResource(id = R.string.welcome_back),
                    style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.tertiaryFixed),
                )
            }

            IconButton(
                onClick = {
                    hasUnreadNotification = false
                    onNotificationClick()
                }
            ) {
                val surfaceColor = MaterialTheme.colorScheme.surface
                Icon(
                    modifier = Modifier
                        .size(NutrifyTheme.sizing.large)
                        .drawWithContent {
                            drawContent()

                            if (hasUnreadNotification) {
                                val circleRadius =
                                    size.minDimension / NOTIFICATION_BADGE_OUTER_CIRCLE_RATIO

                                val circleOffset = Offset(
                                    x = size.width * NOTIFICATION_BADGE_OFFSET_X_RATIO,
                                    y = size.height * NOTIFICATION_BADGE_OFFSET_Y_RATIO
                                )

                                drawCircle(
                                    color = surfaceColor,
                                    radius = circleRadius,
                                    center = circleOffset
                                )

                                drawCircle(
                                    color = Secondary,
                                    radius = circleRadius / NOTIFICATION_BADGE_INNER_CIRCLE_RATIO,
                                    center = circleOffset
                                )
                            }
                        },
                    painter = painterResource(id = R.drawable.ic_bell),
                    contentDescription = stringResource(id = R.string.notification),
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProfileAppbarPreview() {
    NutrifyTheme {
        ProfileAppbar(
            profilePicture = R.drawable.img_nutritional_news_1,
            userName = "Endrew",
            onProfileClick = {},
            onNotificationClick = {}
        )
    }
}

@Preview
@Composable
private fun ProfileAppbarWithNotificationPreview() {
    NutrifyTheme {
        ProfileAppbar(
            profilePicture = R.drawable.img_nutritional_news_1,
            userName = "Endrew",
            hasUnreadNotification = true,
            onProfileClick = {},
            onNotificationClick = {}
        )
    }
}