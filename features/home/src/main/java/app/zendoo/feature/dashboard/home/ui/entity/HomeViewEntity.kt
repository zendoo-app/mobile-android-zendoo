package app.zendoo.feature.dashboard.home.ui.entity

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import javax.inject.Inject

class HomeViewEntity
@Inject
constructor(
    @DrawableRes val foreground: Int?,
    @StringRes val titleRes: Int?,
    @StringRes val subtitleRes: Int?,
    val progressBarProgress: Int,
    @DrawableRes val drawableRes: Int?,
    @StringRes val buttonRes: Int?,
    val buttonListener: View.OnClickListener?
)

