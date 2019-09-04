package app.zendoo.libraries.ui.adapter

import android.view.View
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

object ViewBindingAdapter {

    @BindingAdapter("android:foreground")
    @JvmStatic
    fun setForeground(view: View, @DrawableRes resource: Int?) {
        resource?.let {
            val context = view.context
            view.foreground = context.getDrawable(it)
        }
    }
}
