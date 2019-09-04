package app.zendoo.libraries.ui.adapter

import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter

object ButtonBindingAdapter {

    @BindingAdapter("android:text")
    @JvmStatic
    fun setText(view: AppCompatButton, @StringRes resource: Int?) {
        resource?.let {
            val context = view.context
            view.text = context.getString(it)
            view.visibility = View.VISIBLE
        } ?: run {
            view.visibility = View.INVISIBLE
        }
    }

    @BindingAdapter("android:onClick")
    @JvmStatic
    fun onClick(view: AppCompatButton, onClickListener: View.OnClickListener?) {
        onClickListener?.let {
            view.setOnClickListener(it)
            view.isClickable = true
        } ?: run {
            view.isClickable = false
        }
    }
}
