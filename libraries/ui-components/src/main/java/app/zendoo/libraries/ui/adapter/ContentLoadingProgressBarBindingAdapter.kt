package app.zendoo.libraries.ui.adapter

import android.view.View
import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter

object ContentLoadingProgressBarBindingAdapter {

    @BindingAdapter("android:progress")
    @JvmStatic
    fun setContentLoadingProgressBar(view: ContentLoadingProgressBar, value: Int?) {
        value?.let {
            view.progress = value
            view.visibility = View.VISIBLE
        } ?: run {
            view.visibility = View.INVISIBLE
        }
    }
}
