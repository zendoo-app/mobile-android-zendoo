package app.zendoo.namaste.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import app.zendoo.namaste.Asd
import app.zendoo.namaste.R
import app.zendoo.namaste.util.navigation.ZendooFeatureHost
import app.zendoo.namaste.util.navigation.ZendooNavigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

@SuppressLint("GoogleAppIndexingApiWarning")
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

        val asd = Asd(this)
        asd.asd(1, 2)
        asd.bsd()
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyNavigator()
    }

    //endregion

    //region DashboardNavigator

    private fun initNavigator() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_zendoo)
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
