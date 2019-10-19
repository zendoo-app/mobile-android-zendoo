package app.zendoo.feature.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import app.zendoo.feature.home.R
import app.zendoo.feature.home.util.HomeFragmentHost
import app.zendoo.feature.home.util.HomeNavigator
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
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

        navigator.init(
            navFragment = (childFragmentManager.findFragmentById(R.id.nav_host_fragment_home) as NavHostFragment?),
            navController = navController,
            homeExitNavigator = (parentFragment?.parentFragment as HomeFragmentHost).getNavigator()
        )
        viewModel.state.observe(
            viewLifecycleOwner,
            Observer { navigator.navigate(it) })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("delayed causing race condition thus disabled")
        // navigator.destroy()
    }

    //endregion
}
