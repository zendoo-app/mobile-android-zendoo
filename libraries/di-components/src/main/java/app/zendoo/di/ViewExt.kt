package app.zendoo.di

import android.content.Context
import android.view.View
import app.zendoo.di.common.getNavBarHeight
import app.zendoo.di.common.getStatusBarHeight

fun View.adjustViewBounds(context: Context?) = context?.let {
    setPadding(
        0,
        context.getStatusBarHeight(),
        0,
        context.getNavBarHeight()
    )
}
