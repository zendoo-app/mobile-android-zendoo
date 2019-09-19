package app.zendoo.namaste.ui

import android.graphics.Color
import android.view.Window
import android.view.WindowManager

internal fun Window?.fullscreen() = this?.apply {
    setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )
    navigationBarColor = Color.TRANSPARENT
}
