package app.zendoo.feature.player.ui.entity

import androidx.annotation.DrawableRes

data class PlayerViewEntity(
    @DrawableRes val leftImage: Int,
    @DrawableRes val middleImage: Int,
    @DrawableRes val rightImage: Int
)
