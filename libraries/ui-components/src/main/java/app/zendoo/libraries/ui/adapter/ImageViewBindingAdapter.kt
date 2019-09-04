package app.zendoo.libraries.ui.adapter

import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter

object ImageViewBindingAdapter {

    @BindingAdapter("android:src")
    @JvmStatic
    fun setImageResource(view: AppCompatImageView, @DrawableRes resource: Int?) {
        resource?.let {
            view.setImageResource(it)
            view.visibility = View.VISIBLE
        } ?: run {
            view.visibility = View.INVISIBLE
        }
    }
}
