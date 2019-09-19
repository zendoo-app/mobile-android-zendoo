package app.zendoo.namaste.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import app.zendoo.namaste.R
import app.zendoo.namaste.util.navigation.ZendooFeatureHost
import app.zendoo.namaste.util.navigation.ZendooNavigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Singleton

@SuppressLint("GoogleAppIndexingApiWarning")
@Singleton
class ZendooActivity :
    DaggerAppCompatActivity(),
    ZendooFeatureHost {

    //region @Inject

    @Inject
    lateinit var navigator: ZendooNavigator

    //endregion

    //region var

    private var navController: NavController? = null

    //endregion

    //region DaggerAppCompatActivity

    public override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ZendooTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zendoo)

        initNavigator()

        window.fullscreen()
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyNavigator()
    }

    //endregion

    //region DashboardNavigator

    private fun initNavigator() {
        navController = findNavController(R.id.nav_host_fragment_zendoo)
        navController?.let { navController ->
            navigator.init(navController = navController)
        }
    }

    private fun destroyNavigator() {
        navController = null
        navigator.destroy()
    }

    //endregion

    //region ZendooFeatureHost

    override fun getZendooNavigator() = navigator

    //endregion
}
