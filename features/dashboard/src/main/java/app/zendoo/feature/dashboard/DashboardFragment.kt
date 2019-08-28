package app.zendoo.feature.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardFragment : Fragment() {

    //region lateinit

    private lateinit var viewModel: DashboardViewModel

    //endregion

    //region lazy

    private val navDashboardController: NavController? by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host_fragment_dashboard) as NavHostFragment?)?.navController
    }

    //endregion

    //region Fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        setupBottomNavigationView(view)
        val navView: BottomNavigationView = view.findViewById(R.id.bottom_nav_dashboard)
        setupWithNavController(navView, navDashboardController!!)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
    }

    //endregion

    //region BottomNavigationView

    private fun setupBottomNavigationView(view: View) {
        val navView: BottomNavigationView = view.findViewById(R.id.bottom_nav_dashboard)
        setupWithNavController(navView, navDashboardController!!)
    }

    //endregion
}
