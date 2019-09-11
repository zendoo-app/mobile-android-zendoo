package app.zendoo.feature.dashboard.home.util

import app.zendoo.feature.player.util.PlayerBundle
import app.zendoo.feature.player.util.PlayerEnterNavigation
import app.zendoo.feature.player.util.PlayerEnterNavigation.Companion.toPlayerBundle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeNavigator
@Inject
constructor() : PlayerEnterNavigation {

    lateinit var navigation: HomeExitNavigation

    //region PlayerEnterNavigation

    fun exitProgressing(id: Int) {
        enterPlayer(id.toPlayerBundle())
    }

    fun exitStarting(id: Int) {
        enterPlayer(id.toPlayerBundle())
    }

    //endregion

    //region PlayerEnterNavigation

    override fun enterPlayer(bundle: PlayerBundle) {
        navigation.exitHome(bundle)
    }

    //endregion
}
