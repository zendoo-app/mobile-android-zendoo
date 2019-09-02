package app.zendoo.feature.dashboard.di

import app.zendoo.di.scope.FragmentScope
import app.zendoo.feature.dashboard.DashboardFragment
import app.zendoo.feature.dashboard.home.di.HomeFeatureBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [

    ]
)
abstract class DashboardFeatureBuilder {

    //region DashboardFragment

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            (HomeFeatureBuilder::class)
        ]
    )
    abstract fun dashboardFragment(): DashboardFragment

    //endregion
}
