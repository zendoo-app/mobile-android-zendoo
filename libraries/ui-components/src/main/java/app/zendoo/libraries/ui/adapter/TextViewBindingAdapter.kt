package app.zendoo.libraries.ui.adapter

import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter

object TextViewBindingAdapter {

    @BindingAdapter("android:text")
    @JvmStatic
    fun setText(view: AppCompatTextView, @StringRes resource: Int?) {
        resource?.let {
            val context = view.context
            view.text = context.getString(it)
            view.visibility = View.VISIBLE
        } ?: run {
            view.visibility = View.INVISIBLE
        }
    }
}
