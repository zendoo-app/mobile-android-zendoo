package app.zendoo.feature.dashboard.home.di.home

import app.zendoo.feature.dashboard.home.di.loading.LoadingFeatureBuilder
import app.zendoo.feature.dashboard.home.di.starting.StartingFeatureBuilder
import app.zendoo.feature.dashboard.home.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFeatureBuilder {

    //region HomeFragment

    @HomeScope
    @ContributesAndroidInjector(
        modules = [
            (HomeFragmentModule::class),
            (LoadingFeatureBuilder::class),
            (StartingFeatureBuilder::class)
        ]
    )
    abstract fun homeFragment(): HomeFragment

    //endregion
}
