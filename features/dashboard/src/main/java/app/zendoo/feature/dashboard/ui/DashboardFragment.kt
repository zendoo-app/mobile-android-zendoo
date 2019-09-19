package app.zendoo.feature.dashboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import app.zendoo.feature.dashboard.R
import app.zendoo.feature.dashboard.databinding.FragmentDashboardBinding
import app.zendoo.feature.dashboard.util.DashboardExitNavigator
import app.zendoo.feature.dashboard.util.DashboardFragmentHost
import app.zendoo.feature.dashboard.util.DashboardNavigator
import app.zendoo.feature.dashboard.util.init
import app.zendoo.feature.home.ui.HomeViewModel
import app.zendoo.feature.home.util.HomeExitNavigator
import app.zendoo.feature.home.util.HomeFragmentHost
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DashboardFragment :
    DaggerFragment(),
    HomeFragmentHost {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var navigator: DashboardNavigator

    //endregion

    //region var

    private var binding: FragmentDashboardBinding? = null

    //endregion

    //region val

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    //endregion

    //region lazy

    private val navController: NavController? by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host_fragment_dashboard) as NavHostFragment?)?.navController
    }
    private val dashboardExitNavigator: DashboardExitNavigator by lazy {
        (parentFragment?.activity as DashboardFragmentHost).getDashboardExitNavigator()
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
            R.layout.fragment_dashboard,
            container,
            false
        )

        binding.init(context, viewLifecycleOwner)
        navController.init(binding)
        navigator.init(dashboardExitNavigator)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        navigator.destroy()
    }

    //endregion

    //region HomeFragmentHost

    override fun getNavigator(): HomeExitNavigator = navigator

    //endregion
}
