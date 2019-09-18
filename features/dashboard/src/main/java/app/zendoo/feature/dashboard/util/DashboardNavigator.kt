package app.zendoo.feature.dashboard.util

import app.zendoo.feature.dashboard.home.util.HomeExitNavigator
import app.zendoo.feature.player.util.PlayerBundle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardNavigator
@Inject
constructor() : HomeExitNavigator {

    lateinit var navControll: DashboardNavigation

    override fun exitHome(bundle: PlayerBundle) {
        navControll.exitHome(bundle)
    }
}
