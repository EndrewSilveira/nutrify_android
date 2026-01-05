package com.e.rezende.nutrify.domain.models.news

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.util.UUID
import kotlin.random.Random

@Parcelize
data class News(
    val id: UUID = UUID.randomUUID(),
    val description: String = "",
    @field:DrawableRes val imageResource: Int,
    val tags: List<NewsTags> = emptyList(),
    val readingTime: Long = 0L,
): Parcelable