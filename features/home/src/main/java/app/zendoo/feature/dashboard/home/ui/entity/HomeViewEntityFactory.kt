package app.zendoo.feature.dashboard.home.ui.entity

import app.zendoo.feature.dashboard.home.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewEntityFactory
@Inject
constructor() {

    //region HomeViewEntityFactory

    fun create(enum: HomeViewEntityEnum): HomeViewEntity = when (enum) {
        HomeViewEntityEnum.LOADING -> createLoadingViewEntity()
        HomeViewEntityEnum.WORKING -> TODO()
        HomeViewEntityEnum.STARTING -> createStartViewEntity()
    }

    //endregion

    //region HomeViewEntity

    private fun createLoadingViewEntity() = HomeViewEntity(
        foreground = R.drawable.skeleton,
        titleRes = R.string.start_title,
        subtitleRes = R.string.start_subtitle,
        progressBarProgress = 0,
        drawableRes = R.drawable.ic_cutiepie,
        buttonRes = R.string.all_start,
        buttonListener = null
    )

    private fun createStartViewEntity() = HomeViewEntity(
        foreground = null,
        titleRes = R.string.start_title,
        subtitleRes = R.string.start_subtitle,
        progressBarProgress = 0,
        drawableRes = R.drawable.ic_cutiepie,
        buttonRes = R.string.all_start,
        buttonListener = null
    )

    //endregion
}
