package com.e.rezende.nutrify.domain.models.ingredients

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingredient(
    val name: String,
    val quantity: Double
): Parcelable
