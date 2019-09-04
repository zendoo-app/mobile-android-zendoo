package app.zendoo.feature.dashboard.home.ui.entity

import android.view.View
import app.zendoo.feature.dashboard.home.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewEntityFactory
@Inject
constructor() {

    //region HomeViewEntityFactory

    fun create(enum: HomeViewEntityEnum): HomeViewEntity = when (enum) {
        HomeViewEntityEnum.START -> createStartHomeViewEntity()
        HomeViewEntityEnum.PROGRESS -> TODO()
        HomeViewEntityEnum.DONE -> TODO()
    }

    //endregion

    //region HomeViewEntity

    private fun createStartHomeViewEntity() = HomeViewEntity(
        titleRes = R.string.start_title,
        subtitleRes = R.string.start_subtitle,
        progressBarVisibility = true,
        progressBarProgress = 0,
        buttonRes = R.string.all_start,
        buttonListener = View.OnClickListener { }
    )

    //endregion
}
