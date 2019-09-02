package app.zendoo.feature.dashboard.di

import app.zendoo.di.FragmentScope
import app.zendoo.feature.dashboard.DashboardFragment
import app.zendoo.feature.dashboard.home.di.HomeFeatureBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        (HomeFeatureBuilder::class)
    ]
)
abstract class DashboardFeatureBuilder {

    //region DashboardFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(DashboardFragmentModule::class)])
    abstract fun dashboardFragment(): DashboardFragment

    //endregion

}
