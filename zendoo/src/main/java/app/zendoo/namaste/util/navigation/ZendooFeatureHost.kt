package app.zendoo.namaste.util.navigation

import app.zendoo.feature.dashboard.util.DashboardFragmentHost
import app.zendoo.feature.dashboard.util.DashboardNavigation
import app.zendoo.feature.player.util.PlayerExitNavigation
import app.zendoo.feature.player.util.PlayerFragmentHost

interface ZendooFeatureHost :
    DashboardFragmentHost,
    PlayerFragmentHost {

    // TODO(JN): abstract host and navigation

    //region ZendooFeatureHost

    fun getZendooNavigator(): ZendooNavigator

    //endregion

    //region DashboardFragmentHost

    override fun getDashboardNavigator(): DashboardNavigation {
        return getZendooNavigator()
    }

    //endregion

    //region PlayerFragmentHost

    override fun getPlayerNavigator(): PlayerExitNavigation {
        return getZendooNavigator()
    }

    //endregion
}
