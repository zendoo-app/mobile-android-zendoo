package app.zendoo.feature.dashboard.home.ui.entity

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

 class HomeViewEntity constructor(
    @DrawableRes val foreground: Int? = null,
    @StringRes val titleRes: Int? = null,
    @StringRes val subtitleRes: Int? = null,
    val progressNow: Int? = null,
    val progressMax: Int? = null,
    val progressBarProgress: Int? = null,
    @DrawableRes val drawableRes: Int? = null,
    @StringRes val buttonRes: Int? = null,
    val buttonListener: View.OnClickListener? = null
) {}
