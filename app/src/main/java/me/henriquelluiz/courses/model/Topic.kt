package me.henriquelluiz.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import me.henriquelluiz.courses.R

data class Topic(
    @StringRes val name: Int,
    val items: Int,
    @DrawableRes val image: Int,
    @DrawableRes val grainIcon: Int = R.drawable.ic_grain
)
