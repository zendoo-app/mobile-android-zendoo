package app.zendoo.feature.dashboard.home.util

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import app.zendoo.feature.dashboard.home.R
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntityEnum
import app.zendoo.feature.dashboard.home.ui.loading.LoadingFragment
import app.zendoo.feature.dashboard.home.ui.progress.ProgressFragment
import app.zendoo.feature.dashboard.home.ui.start.StartFragment
import app.zendoo.feature.player.util.PlayerBundle
import app.zendoo.feature.player.util.PlayerEnterNavigation
import app.zendoo.feature.player.util.PlayerEnterNavigation.Companion.toPlayerBundle
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeNavigator
@Inject
constructor() : PlayerEnterNavigation {

    //region lateinit

    lateinit var homeExitNavigator: HomeExitNavigator

    //endregion

    //region var

    var navController: NavController? = null
    var navFragment: NavHostFragment? = null

    //endregion

    //region HomeNavigator

    fun navigate(state: HomeViewEntityEnum?) {
        Timber.e("${getCurrentFragment()} to $state")
        when (getCurrentFragment()) {
            LoadingFragment::class -> {
                navigateFromLoading(state)
            }
            StartFragment::class -> {
                navigateFromStart(state)
            }
            ProgressFragment::class -> {
                navigateFromProgress(state)
            }
        }
    }

    private fun navigateFromLoading(state: HomeViewEntityEnum?) =
        when (state) {
            HomeViewEntityEnum.START -> navController?.navigate(R.id.action_loading_to_start)
            HomeViewEntityEnum.PROGRESS -> navController?.navigate(R.id.action_loading_to_progress)
            else -> {
            }
        }

    private fun navigateFromStart(state: HomeViewEntityEnum?) {
        Timber.e("${getCurrentFragment()} to $state")
        when (state) {
            HomeViewEntityEnum.PROGRESS -> navController?.navigate(R.id.action_start_to_progress)
            else -> {
                Timber.e("cannot navigate from StartFragment $state")
            }
        }
    }

    private fun navigateFromProgress(state: HomeViewEntityEnum?) =
        when (state) {
            else -> {
                Timber.e("cannot navigate from ProgressFragment $state")
            }
        }

    private fun getCurrentFragment() = navFragment?.childFragmentManager?.fragments?.get(0)?.let {
        it::class
    }

    //endregion

    //region PlayerEnterNavigation

    fun exitProgress(id: Int) {
        Timber.e("$id")
        enterPlayer(id.toPlayerBundle())
    }

    fun exitStart(id: Int) {
        Timber.e("$id")
        enterPlayer(id.toPlayerBundle())
    }

    //endregion

    //region PlayerEnterNavigation

    override fun enterPlayer(bundle: PlayerBundle) {
        homeExitNavigator.exitHome(bundle)
    }

    //endregion
}
