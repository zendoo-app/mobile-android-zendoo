package app.zendoo.feature.dashboard.home.di

import app.zendoo.di.scope.DashboardScope
import app.zendoo.feature.dashboard.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
    ]
)
abstract class HomeFeatureBuilder {

    //region HomeFragment

    @DashboardScope
    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    //endregion
}
