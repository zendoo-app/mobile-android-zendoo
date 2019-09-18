package app.zendoo.feature.dashboard.home.ui.entity

import android.view.View
import app.zendoo.domain.model.Session
import app.zendoo.feature.dashboard.home.R
import app.zendoo.feature.dashboard.home.util.HomeNavigator
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class HomeViewEntityFactory
@Inject
constructor(private val homeNavigator: HomeNavigator) {

    //region HomeViewEntityFactory

    fun create(session: Session?): HomeViewEntity = when (session.toEnum()) {
        HomeViewEntityEnum.LOADING -> createLoadingViewEntity()
        // TODO(JN): remove force
        HomeViewEntityEnum.PROGRESSING -> createProgressingViewEntity(session!!)
        HomeViewEntityEnum.STARTING -> createStartingViewEntity(session!!)
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
            buttonListener = View.OnClickListener {
                homeNavigator.exitProgressing(session.id)
            }
        )

    private fun createStartingViewEntity(session: Session) =
        HomeViewEntity(
            foreground = null,
            titleRes = R.string.start_title,
            subtitleRes = R.string.start_subtitle,
            progressBarProgress = 0,
            drawableRes = R.drawable.ic_cutie_pie,
            buttonRes = R.string.all_start,
            buttonListener = View.OnClickListener {
                // homeNavigator.exitStarting(session.id)
                homeNavigator.exitStarting(Random(100).nextInt())
            }
        )

    //endregion
}
