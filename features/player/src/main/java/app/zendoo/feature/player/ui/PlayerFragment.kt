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
import app.zendoo.feature.player.util.PlayerExitNavigator
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

    //region lazy

    private val playerExitNavigator: PlayerExitNavigator by lazy {
        (parentFragment?.activity as PlayerFragmentHost).getPlayerNavigator()
    }
    private val sessionId by lazy { arguments?.getSessionId() ?: -1 }

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

        viewModel.setId(sessionId)

        binding.init(viewLifecycleOwner, viewModel)
        navigator.init(playerExitNavigator)

        initOnNavigationUp()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        navigator.destroy()
    }

    private fun initOnNavigationUp() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navigator.onNavigationUp()
        }
    }

    //endregion
}
