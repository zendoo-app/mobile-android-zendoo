package app.zendoo.feature.dashboard.di

import app.zendoo.feature.dashboard.DashboardFragment
import app.zendoo.feature.dashboard.home.di.home.HomeFeatureBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DashboardFeatureBuilder {

    //region DashboardFragment

    @DashboardScope
    @ContributesAndroidInjector(
        modules = [
            (HomeFeatureBuilder::class),
            (DashboardFragmentModule::class)
        ]
    )
    abstract fun dashboardFragment(): DashboardFragment

    //endregion
}
