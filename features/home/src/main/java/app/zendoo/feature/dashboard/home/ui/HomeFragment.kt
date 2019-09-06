package app.zendoo.feature.dashboard.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import app.zendoo.feature.dashboard.home.R
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntityEnum
import app.zendoo.feature.dashboard.home.util.HomeFragmentHost
import app.zendoo.feature.dashboard.home.util.HomeNavigator
import app.zendoo.libraries.ui.asd.observe
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var navigator: HomeNavigator

    //endregion

    //region lateinit

    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    //endregion

    //region lazy

    private val navController: NavController? by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host_fragment_home) as NavHostFragment?)?.navController
    }

    //endregion

    //region DaggerFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initNavigator()

        observe(viewModel.state, ::navigate)

        return view
    }

    private fun navigate(state: HomeViewEntityEnum?) {

        when (state) {
            HomeViewEntityEnum.STARTING -> navController?.navigate(R.id.action_to_start)
            HomeViewEntityEnum.PROGRESSING -> navController?.navigate(R.id.action_to_progressing)
            else -> {
            }
        }
    }

    //endregion

    //region HomeNavigator

    private fun initNavigator() {
        navigator.navigation = (parentFragment?.parentFragment as HomeFragmentHost).getNavigator()
    }

    //endregion
}
