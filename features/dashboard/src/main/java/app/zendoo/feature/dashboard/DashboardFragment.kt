package app.zendoo.feature.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DashboardFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //endregion

    //region lateinit

    private lateinit var viewModel: DashboardViewModel

    //endregion

    //region lazy

    private val navDashboardController: NavController? by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host_fragment_dashboard) as NavHostFragment?)?.navController
    }

    //endregion

    //region DaggerFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        setupBottomNavigationView(view)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[DashboardViewModel::class.java]
    }

    //endregion

    //region BottomNavigationView

    private fun setupBottomNavigationView(view: View) {
        val navView: BottomNavigationView = view.findViewById(R.id.bottom_nav_dashboard)
        setupWithNavController(navView, navDashboardController!!)
    }

    //endregion
}
