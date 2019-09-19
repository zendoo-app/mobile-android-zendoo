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
import androidx.navigation.ui.NavigationUI.setupWithNavController
import app.zendoo.feature.dashboard.R
import app.zendoo.feature.dashboard.databinding.FragmentDashboardBinding
import app.zendoo.feature.dashboard.util.DashboardFragmentHost
import app.zendoo.feature.dashboard.util.DashboardNavigator
import app.zendoo.feature.home.ui.HomeViewModel
import app.zendoo.feature.home.util.HomeExitNavigator
import app.zendoo.feature.home.util.HomeFragmentHost
import com.google.android.material.bottomnavigation.BottomNavigationView
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

    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    //endregion

    //region lazy

    private val navController: NavController? by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host_fragment_dashboard) as NavHostFragment?)?.navController
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

        initBinding()
        initNavigator()
        setupBottomNavigationView()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        destroyBinding()
        destroyNavigator()
    }

    //endregion

    //region binding

    private fun initBinding() {
        binding?.lifecycleOwner = viewLifecycleOwner
    }

    private fun destroyBinding() {
        binding = null
    }

    //endregion

    //region BottomNavigationView

    private fun setupBottomNavigationView() {
        binding?.root?.let { view ->
            val navView: BottomNavigationView = view.findViewById(R.id.bottom_nav_dashboard)
            navController?.let { navController ->
                setupWithNavController(navView, navController)
            }
        }
    }

    //endregion

    //region HomeFragmentHost

    override fun getNavigator(): HomeExitNavigator = navigator

    //endregion

    //region DashboardNavigator

    private fun initNavigator() {
        navigator.init(dashboardExitNavigator = (parentFragment?.activity as DashboardFragmentHost).getDashboardNavigator())
    }

    private fun destroyNavigator() {
        navigator.destroy()
    }

    //endregion
}
