package app.zendoo.namaste.util.navigation

import androidx.navigation.NavController
import app.zendoo.feature.dashboard.util.DashboardNavigation
import app.zendoo.feature.player.util.PlayerBundle
import app.zendoo.feature.player.util.PlayerEnterNavigation
import app.zendoo.feature.player.util.PlayerEnterNavigation.Companion.toBundle
import app.zendoo.feature.player.util.PlayerExitNavigation
import app.zendoo.namaste.R
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ZendooNavigator
@Inject
constructor() :
    DashboardNavigation,
    PlayerExitNavigation,
    PlayerEnterNavigation {

    //region lateinit

    lateinit var navController: NavController

    //endregion

    //region DashboardNavigation

    override fun exitHome(bundle: PlayerBundle) {
        enterPlayer(bundle)
    }

    //endregion

    //region PlayerEnterNavigation

    override fun enterPlayer(bundle: PlayerBundle) {
        Timber.e("${bundle.id}")
        navController.navigate(R.id.action_dashboard_to_player, bundle.toBundle())
    }

    //endregion

    //region PlayerExitNavigation

    override fun onNavigationUp() {
        navController.navigateUp()
    }

    //endregion
}
