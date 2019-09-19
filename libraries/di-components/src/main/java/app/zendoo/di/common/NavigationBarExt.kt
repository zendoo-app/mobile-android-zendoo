package app.zendoo.di.common

import android.content.Context

fun Context.getNavBarHeight(): Int {
    val resourceId = resources.getIdentifier(
        "navigation_bar_height",
        "dimen",
        "android"
    )
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else 0
}
