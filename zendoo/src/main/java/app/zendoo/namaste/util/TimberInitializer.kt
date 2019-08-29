package app.zendoo.namaste.util

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimberInitializer
@Inject
internal constructor(
    private val buildConfig: BuildConfigProvider,
    private val timberDebugTree: TimberDebugTree
) {

    //region TimberInitializer

    fun init() {
        if (buildConfig.isDebug()) {
            val seed = timberDebugTree.tree
            Timber.plant(seed)
        }
    }

    //endregion
}
