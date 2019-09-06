package app.zendoo.feature.player.util

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerNavigator
@Inject
constructor() {

    lateinit var navigation: PlayerExitNavigation

    fun onNavigationUp() {
        navigation.onNavigationUp()
    }
}
