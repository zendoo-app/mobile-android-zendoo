package app.zendoo.namaste.util

import app.zendoo.namaste.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BuildConfigProvider
@Inject
constructor() {

    //region BuildConfigProvider

    fun isDebug() = BuildConfig.DEBUG

    //endregion

}
