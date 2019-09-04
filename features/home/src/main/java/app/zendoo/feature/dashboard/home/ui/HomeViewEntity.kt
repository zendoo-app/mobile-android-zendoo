package app.zendoo.feature.dashboard.home.ui

import android.view.View
import androidx.annotation.StringRes

data class HomeViewEntity(
    @StringRes val titleRes: Int,
    @StringRes val subtitleRes: Int,
    val progressBarVisibility: Boolean,
    val progressBarProgress: Int,
    @StringRes val buttonRes: Int,
    val buttonListener: View.OnClickListener
)
