package app.zendoo.feature.player.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import app.zendoo.feature.player.R
import app.zendoo.feature.player.databinding.FragmentPlayerBinding
import app.zendoo.feature.player.util.PlayerEnterNavigation.Companion.getSessionId
import app.zendoo.feature.player.util.PlayerFragmentHost
import app.zendoo.feature.player.util.PlayerNavigator
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class PlayerFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var navigator: PlayerNavigator

    //endregion

    //region lateinit

    private lateinit var binding: FragmentPlayerBinding

    //endregion

    //region val

    private val viewModel: PlayerViewModel by viewModels {
        viewModelFactory
    }

    //endregion

    //region DaggerFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_player,
            container,
            false
        )

        initSessionId()
        initNavigator()
        initOnNavigationUp()

        binding.lifecycleOwner = this
        binding.viewModel = viewModel.viewEntity

        return binding.root
    }

    private fun initSessionId() {
        val id = arguments?.getSessionId() ?: -1
        Timber.e("$id")
        viewModel.setId(id)
    }

    private fun initOnNavigationUp() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            navigator.onNavigationUp()
        }
    }

    //endregion

    //region DashboardNavigator

    private fun initNavigator() {
        navigator.navigation =
            (parentFragment?.activity as PlayerFragmentHost).getPlayerNavigator()
    }

    //endregion
}
