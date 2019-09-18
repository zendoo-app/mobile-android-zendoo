package app.zendoo.namaste.util.navigation

import app.zendoo.feature.dashboard.util.DashboardExitNavigator
import app.zendoo.feature.dashboard.util.DashboardFragmentHost
import app.zendoo.feature.player.util.PlayerExitNavigator
import app.zendoo.feature.player.util.PlayerFragmentHost

interface ZendooFeatureHost :
    DashboardFragmentHost,
    PlayerFragmentHost {

    // TODO(JN): abstract host and navigation

    //region ZendooFeatureHost

    fun getZendooNavigator(): ZendooNavigator

    //endregion

    //region DashboardFragmentHost

    override fun getDashboardNavigator(): DashboardExitNavigator {
        return getZendooNavigator()
    }

    //endregion

    //region PlayerFragmentHost

    override fun getPlayerNavigator(): PlayerExitNavigator {
        return getZendooNavigator()
    }

    //endregion
}
