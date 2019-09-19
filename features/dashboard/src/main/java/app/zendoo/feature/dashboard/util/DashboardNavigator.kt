package app.zendoo.feature.dashboard.util

import app.zendoo.feature.home.util.HomeExitNavigator
import app.zendoo.feature.player.util.PlayerBundle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardNavigator
@Inject
constructor() : HomeExitNavigator {

    //region var

    private var dashboardExitNavigator: DashboardExitNavigator? = null

    //endregion

    //region DashboardNavigator

    fun init(dashboardExitNavigator: DashboardExitNavigator) {
        set(dashboardExitNavigator = dashboardExitNavigator)
    }

    fun destroy() {
        set()
    }

    fun set(dashboardExitNavigator: DashboardExitNavigator? = null) {
        this.dashboardExitNavigator = dashboardExitNavigator
    }

    //endregion

    //region HomeExitNavigator

    override fun exitHome(bundle: PlayerBundle) {
        dashboardExitNavigator?.exitHome(bundle)
    }

    //endregion
}
