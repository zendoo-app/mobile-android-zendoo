package app.zendoo.feature.player.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import app.zendoo.feature.player.R
import app.zendoo.feature.player.util.PlayerEnterNavigator.Companion.getSessionId
import app.zendoo.feature.player.util.PlayerExitNavigator
import app.zendoo.feature.player.util.PlayerFragmentHost
import app.zendoo.feature.player.util.PlayerNavigator
import dagger.android.support.DaggerFragment
import timber.log.Timber
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

    //region lateinit

    private val viewModel: PlayerViewModel by viewModels {
        viewModelFactory
    }
    private val playerExitNavigator: PlayerExitNavigator by lazy {
        (parentFragment?.activity as PlayerFragmentHost).getPlayerNavigator()
    }
    //endregion

    //region lazy

    private val navController: NavController? by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host_fragment_player) as NavHostFragment?)?.navController
    }
    private val sessionId by lazy { arguments?.getSessionId() ?: -1 }

    //endregion

    //region DaggerFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player, container, false)

        viewModel.setId(sessionId)

        navigator.init(playerExitNavigator = (activity as PlayerFragmentHost).getPlayerNavigator())
        initOnNavigationUp()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("delayed causing race condition thus disabled")
        // navigator.destroy()
    }

    private fun initOnNavigationUp() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navigator.onNavigationUp()
        }
    }

    //endregion
}
