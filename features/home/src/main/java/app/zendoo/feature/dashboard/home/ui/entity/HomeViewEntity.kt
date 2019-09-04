package app.zendoo.feature.dashboard.home.ui.entity

import android.view.View
import androidx.annotation.StringRes
import javax.inject.Inject

class HomeViewEntity
@Inject
constructor(
    @StringRes val titleRes: Int,
    @StringRes val subtitleRes: Int,
    val progressBarVisibility: Boolean,
    val progressBarProgress: Int,
    @StringRes val buttonRes: Int,
    val buttonListener: View.OnClickListener
)
