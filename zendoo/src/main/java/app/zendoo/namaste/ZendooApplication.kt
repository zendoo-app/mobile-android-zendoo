package app.zendoo.namaste

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode
import com.google.android.gms.common.util.PlatformVersion.isAtLeastQ

class ZendooApplication : Application() {

    //region Application

    override fun onCreate() {
        super.onCreate()
        checkNightMode()
    }

    //endregion

    //region

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