package app.zendoo.feature.dashboard.home.ui.entity

import app.zendoo.domain.model.Session
import app.zendoo.feature.dashboard.home.R
import app.zendoo.feature.dashboard.home.ui.toEnum
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewEntityFactory
@Inject
constructor() {

    //region HomeViewEntityFactory

    fun create(session: Session?): HomeViewEntity = when (session.toEnum()) {
        HomeViewEntityEnum.LOADING -> createLoadingViewEntity()
        // TODO(JN): remove force
        HomeViewEntityEnum.PROGRESSING -> createProgressingViewEntity(session!!)
        HomeViewEntityEnum.STARTING -> createStartingViewEntity()
    }

    //endregion

    //region HomeViewEntity

    private fun createLoadingViewEntity() =
        HomeViewEntity(
            foreground = R.drawable.skeleton,
            titleRes = R.string.start_title,
            subtitleRes = R.string.start_subtitle,
            progressBarProgress = -1,
            drawableRes = R.drawable.ic_cutie_pie,
            buttonRes = R.string.all_start
        )

    private fun createProgressingViewEntity(session: Session) =
        HomeViewEntity(
            titleRes = R.string.progress_title,
            subtitleRes = R.string.progress_subtitle,
            progressNow = session.current,
            progressMax = session.max,
            progressBarProgress = 30,
            drawableRes = R.drawable.ic_cutie_pie,
            buttonRes = R.string.progress_next_session,
            buttonListener = null
        )

    private fun createStartingViewEntity() =
        HomeViewEntity(
            foreground = null,
            titleRes = R.string.start_title,
            subtitleRes = R.string.start_subtitle,
            progressBarProgress = 0,
            drawableRes = R.drawable.ic_cutie_pie,
            buttonRes = R.string.all_start,
            buttonListener = null
        )

    //endregion
}
