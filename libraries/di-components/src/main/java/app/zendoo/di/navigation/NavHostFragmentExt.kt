package app.zendoo.di.navigation

import androidx.navigation.fragment.NavHostFragment

fun NavHostFragment?.getCurrentFragment() = this?.childFragmentManager?.fragments?.get(0)
