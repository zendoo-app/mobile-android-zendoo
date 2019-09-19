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

    //region var

    private var navController: NavController? = null
    private var navFragment: NavHostFragment? = null
    private var homeExitNavigator: HomeExitNavigator? = null

    //endregion

    //region HomeNavigator

    fun init(
        navFragment: NavHostFragment?,
        navController: NavController?,
        homeExitNavigator: HomeExitNavigator?
    ) {
        set(
            navFragment = navFragment,
            navController = navController,
            homeExitNavigator = homeExitNavigator
        )
    }

    fun destroy() {
        set()
    }

    fun set(
        navFragment: NavHostFragment? = null,
        navController: NavController? = null,
        homeExitNavigator: HomeExitNavigator? = null
    ) {
        this.navFragment = navFragment
        this.navController = navController
        this.homeExitNavigator = homeExitNavigator
    }

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
        homeExitNavigator?.run {
            exitHome(bundle)
        }
    }

    //endregion
}
