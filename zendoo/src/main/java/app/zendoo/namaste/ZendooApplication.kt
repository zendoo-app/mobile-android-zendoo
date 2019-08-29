package app.zendoo.namaste

import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode
import app.zendoo.namaste.di.DaggerZendooApplicationComponent
import app.zendoo.namaste.util.ApplicationInitializer
import com.google.android.gms.common.util.PlatformVersion.isAtLeastQ
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class ZendooApplication : DaggerApplication() {

    //region @Inject

    @Inject
    lateinit var initializer: ApplicationInitializer

    //endregion

    //region Application

    override fun onCreate() {
        super.onCreate()
        checkNightMode()

        initApplication()
    }

    //endregion

    //region DaggerApplication

    override fun applicationInjector(): AndroidInjector<out ZendooApplication> {
        val appComponent = DaggerZendooApplicationComponent
            .builder()
            .application(this)
            .build()
        appComponent.inject(this)

        return appComponent
    }

    //endregion

    //region ApplicationInitializer

    private fun initApplication() {
        initializer.init()
    }

    //endregion

    //region setDefaultNightMode

    private fun checkNightMode() {
        val nightMode = if (isAtLeastQ()) {
            MODE_NIGHT_FOLLOW_SYSTEM
        } else {
            MODE_NIGHT_AUTO_BATTERY
        }
        setDefaultNightMode(nightMode)
    }

    //endregion
}
