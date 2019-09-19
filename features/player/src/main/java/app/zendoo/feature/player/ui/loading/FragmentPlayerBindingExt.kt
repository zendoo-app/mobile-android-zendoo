package app.zendoo.feature.player.ui.loading

import androidx.lifecycle.LifecycleOwner
import app.zendoo.feature.player.databinding.FragmentPlayerLoadingBinding
import app.zendoo.feature.player.ui.PlayerViewModel

fun FragmentPlayerLoadingBinding?.init(
    viewLifecycleOwner: LifecycleOwner,
    viewModel: PlayerViewModel
) = this?.apply {
    bind(viewLifecycleOwner, viewModel)
}

fun FragmentPlayerLoadingBinding.bind(
    viewLifecycleOwner: LifecycleOwner?,
    viewModel: PlayerViewModel
) {
    this.lifecycleOwner = viewLifecycleOwner
    this.viewModel = viewModel.viewEntity
}
