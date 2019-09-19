package app.zendoo.feature.player.util

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerNavigator
@Inject
constructor() {

    //region var

    private var playerExitNavigator: PlayerExitNavigator? = null

    //endregion

    //region PlayerNavigator

    fun init(playerExitNavigator: PlayerExitNavigator) {
        set(playerExitNavigator = playerExitNavigator)
    }

    fun destroy() {
        set()
    }

    fun set(playerExitNavigator: PlayerExitNavigator? = null) {
        this.playerExitNavigator = playerExitNavigator
    }

    fun onNavigationUp() {
        playerExitNavigator?.onNavigationUp()
    }

    //endregion
}
