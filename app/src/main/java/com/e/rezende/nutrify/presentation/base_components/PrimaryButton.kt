package com.e.rezende.nutrify.presentation.base_components

import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.e.rezende.nutrify.presentation.theme.NutrifyTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val transition = updateTransition(targetState = isPressed, label = "button_press_transition")

    val shadowAlpha by transition.animateFloat(
        label = "shadow_alpha",
        transitionSpec = { buttonPressAnimation() }
    ) { pressed ->
        if (pressed) 0f else 1f
    }

    Button(
        modifier = modifier
            .dropShadow(
                shape = RoundedCornerShape(corner = CornerSize(NutrifyTheme.sizing.medium)),
                shadow = Shadow(
                    radius = NutrifyTheme.sizing.x9,
                    spread = NutrifyTheme.sizing.x2,
                    color = MaterialTheme.colorScheme.onSurface,
                    alpha = shadowAlpha,
                    offset = DpOffset(x = 0.dp, y = NutrifyTheme.sizing.x9)
                )
            ),
        interactionSource = interactionSource,
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(corner = CornerSize(NutrifyTheme.sizing.medium)),
        contentPadding = PaddingValues(
            vertical = NutrifyTheme.sizing.small,
            horizontal = NutrifyTheme.sizing.large
        )
    ) {
        Text(text = text, style = MaterialTheme.typography.headlineMedium)
    }
}

private fun <T> buttonPressAnimation() = tween<T>(
    durationMillis = 200, easing = Ease
)

@Preview
@Composable
private fun PrimaryButtonPreview() {
    NutrifyTheme {
        PrimaryButton(
            modifier = Modifier
                .padding(10.dp),
            text = "Mais detalhes",
            onClick = {}
        )
    }
}