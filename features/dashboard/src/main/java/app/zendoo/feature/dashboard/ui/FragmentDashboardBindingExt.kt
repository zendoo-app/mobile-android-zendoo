package app.zendoo.feature.dashboard.ui

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import app.zendoo.di.adjustViewBounds
import app.zendoo.feature.dashboard.databinding.FragmentDashboardBinding

fun FragmentDashboardBinding?.init(
    context: Context?,
    viewLifecycleOwner: LifecycleOwner
) = this?.apply {
    root.adjustViewBounds(context)
    bind(viewLifecycleOwner)
}

fun FragmentDashboardBinding.bind(viewLifecycleOwner: LifecycleOwner?) {
    this.lifecycleOwner = viewLifecycleOwner
}
