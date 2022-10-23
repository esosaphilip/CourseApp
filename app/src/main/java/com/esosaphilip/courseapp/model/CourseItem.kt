package com.esosaphilip.courseapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val numAssociated: Int,
    @DrawableRes val imageResourceId: Int
)