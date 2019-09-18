package app.zendoo.feature.home.util

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import app.zendoo.di.navigation.getCurrentFragment
import app.zendoo.feature.home.ui.entity.HomeViewEntityEnum
import app.zendoo.feature.player.util.PlayerBundle
import app.zendoo.feature.player.util.PlayerEnterNavigator
import app.zendoo.feature.player.util.PlayerEnterNavigator.Companion.toPlayerBundle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeNavigator
@Inject
constructor() : PlayerEnterNavigator {

    //region lateinit

    lateinit var homeExitNavigator: HomeExitNavigator

    //endregion

    //region var

    var navController: NavController? = null
    var navFragment: NavHostFragment? = null

    //endregion

    //region HomeNavigator

    fun navigate(state: HomeViewEntityEnum?) {
        navFragment.getCurrentFragment().withDestination(state)?.let {
            navController?.navigate(it)
        }
    }

    //endregion

    //region PlayerEnterNavigation

    fun exitProgress(id: Int) {
        enterPlayer(id.toPlayerBundle())
    }

    fun exitStart(id: Int) {
        enterPlayer(id.toPlayerBundle())
    }

    //endregion

    //region PlayerEnterNavigation

    override fun enterPlayer(bundle: PlayerBundle) {
        homeExitNavigator.exitHome(bundle)
    }

    //endregion
}
