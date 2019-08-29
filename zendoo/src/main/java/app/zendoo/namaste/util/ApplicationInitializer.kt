package app.zendoo.namaste.util

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApplicationInitializer
@Inject
internal constructor(
    private val timber: TimberInitializer
) {

    //region ApplicationInitializer

    fun init() {
        timber.init()
    }

    //endregion
}
