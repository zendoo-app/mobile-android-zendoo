package app.zendoo.namaste.util

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimberDebugTree
@Inject
constructor() {

    //region TimberDebugTree

    val tree: Timber.DebugTree by lazy {
        object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String {
                return super.createStackElementTag(element) + ":${element.lineNumber}"
            }
        }
    }

    //endregion
}
