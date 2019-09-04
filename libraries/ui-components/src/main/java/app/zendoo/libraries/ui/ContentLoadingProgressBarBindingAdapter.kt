package app.zendoo.libraries.ui

import android.view.View
import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter

object ContentLoadingProgressBarBindingAdapter {

    @BindingAdapter("android:progress")
    @JvmStatic
    fun setContentLoadingProgressBar(view: ContentLoadingProgressBar, value: Int) {
        if (value >= 0) {
            view.progress = value
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.INVISIBLE
        }
    }
}
