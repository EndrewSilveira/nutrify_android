package com.e.rezende.nutrify.domain.models.recipe

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.e.rezende.nutrify.domain.models.ingredients.Ingredient
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Recipe(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    @field:DrawableRes val imageResource: Int,
    val calories: Double,
    val ingredients: List<Ingredient>
): Parcelable
