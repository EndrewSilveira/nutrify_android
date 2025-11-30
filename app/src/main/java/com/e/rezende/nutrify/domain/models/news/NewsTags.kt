package com.e.rezende.nutrify.domain.models.news

import androidx.annotation.StringRes
import com.e.rezende.nutrify.R

enum class NewsTags(@field:StringRes val stringResourceId: Int) {
    WELL_BEING(R.string.well_being),
    NUTRITION(R.string.nutrition),
    FOOD_EDUCATION(R.string.food_education)
}
