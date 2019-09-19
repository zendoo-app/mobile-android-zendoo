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
import app.zendoo.feature.player.util.PlayerEnterNavigator.Companion.getSessionId
import app.zendoo.feature.player.util.PlayerFragmentHost
import app.zendoo.feature.player.util.PlayerNavigator
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var navigator: PlayerNavigator

    //endregion

    //region var

    private var binding: FragmentPlayerBinding? = null

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

        initBinding()
        initNavigator()
        initOnNavigationUp()
        initViewModel()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        destroyBinding()
        destroyNavigator()
    }

    private fun initOnNavigationUp() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            navigator.onNavigationUp()
        }
    }

    //endregion

    //region binding

    private fun initBinding() {
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.viewModel = viewModel.viewEntity
    }

    private fun destroyBinding() {
        binding = null
    }

    //endregion

    //region viewModel

    private fun initViewModel() {
        initSessionId()
    }

    private fun initSessionId() {
        val id = arguments?.getSessionId() ?: -1
        viewModel.setId(id)
    }

    //endregion

    //region DashboardNavigator

    private fun initNavigator() {
        navigator.init(playerExitNavigator = (parentFragment?.activity as PlayerFragmentHost).getPlayerNavigator())
    }

    private fun destroyNavigator() {
        navigator.destroy()
    }

    //endregion
}
