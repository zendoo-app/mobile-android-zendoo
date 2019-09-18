package app.zendoo.namaste.util.navigation

import androidx.navigation.NavController
import app.zendoo.feature.dashboard.util.DashboardExitNavigator
import app.zendoo.feature.player.util.PlayerBundle
import app.zendoo.feature.player.util.PlayerEnterNavigator
import app.zendoo.feature.player.util.PlayerEnterNavigator.Companion.toBundle
import app.zendoo.feature.player.util.PlayerExitNavigator
import app.zendoo.namaste.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ZendooNavigator
@Inject
constructor() :
    DashboardExitNavigator,
    PlayerExitNavigator,
    PlayerEnterNavigator {

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
        navController.navigate(R.id.action_dashboard_to_player, bundle.toBundle())
    }

    //endregion

    //region PlayerExitNavigation

    override fun onNavigationUp() {
        navController.navigateUp()
    }

    //endregion
}
