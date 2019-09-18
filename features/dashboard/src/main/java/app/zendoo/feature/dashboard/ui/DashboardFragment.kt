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
import app.zendoo.feature.dashboard.home.ui.HomeViewModel
import app.zendoo.feature.dashboard.home.util.HomeExitNavigator
import app.zendoo.feature.dashboard.home.util.HomeFragmentHost
import app.zendoo.feature.dashboard.util.DashboardFragmentHost
import app.zendoo.feature.dashboard.util.DashboardNavigator
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DashboardFragment :
    DaggerFragment(),
    HomeFragmentHost {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var navigator: DashboardNavigator

    //endregion

    //region lateinit

    private lateinit var binding: FragmentDashboardBinding

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

        initNavigator()
        setupBottomNavigationView(binding.root)

        binding.lifecycleOwner = this
        //  binding.viewModel = viewModel.viewEntity

        return binding.root
    }

    //endregion

    //region BottomNavigationView

    private fun setupBottomNavigationView(view: View) {
        val navView: BottomNavigationView = view.findViewById(R.id.bottom_nav_dashboard)
        setupWithNavController(navView, navController!!)
    }

    //endregion

    //region HomeFragmentHost

    override fun getNavigator(): HomeExitNavigator = navigator

    //endregion

    //region DashboardNavigator

    private fun initNavigator() {
        navigator.navControll =
            (parentFragment?.activity as DashboardFragmentHost).getDashboardNavigator()
    }

    //endregion
}
