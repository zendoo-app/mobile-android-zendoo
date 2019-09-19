package app.zendoo.feature.player.ui

import androidx.lifecycle.LifecycleOwner
import app.zendoo.feature.player.databinding.FragmentPlayerBinding

fun FragmentPlayerBinding?.init(
    viewLifecycleOwner: LifecycleOwner,
    viewModel: PlayerViewModel
) = this?.apply {
    bind(viewLifecycleOwner, viewModel)
}

fun FragmentPlayerBinding.bind(
    viewLifecycleOwner: LifecycleOwner?,
    viewModel: PlayerViewModel
) {
    this.lifecycleOwner = viewLifecycleOwner
    this.viewModel = viewModel.viewEntity
}
