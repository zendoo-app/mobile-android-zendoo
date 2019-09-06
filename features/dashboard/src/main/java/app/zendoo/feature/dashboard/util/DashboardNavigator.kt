package app.zendoo.feature.dashboard.util

import app.zendoo.feature.dashboard.home.util.HomeExitNavigation
import app.zendoo.feature.player.util.PlayerBundle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardNavigator
@Inject
constructor() : HomeExitNavigation {

    lateinit var navigation: DashboardNavigation

    override fun exitHome(bundle: PlayerBundle) {
        navigation.exitHome(bundle)
    }
}
