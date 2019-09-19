package app.zendoo.feature.dashboard.util

import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import app.zendoo.feature.dashboard.R
import app.zendoo.feature.dashboard.databinding.FragmentDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

fun NavController?.init(binding: FragmentDashboardBinding?) =
    binding?.root?.let { view ->
        val navView: BottomNavigationView = view.findViewById(R.id.bottom_nav_dashboard)

        this?.let { navController ->
            NavigationUI.setupWithNavController(navView, navController)
        }
    }
