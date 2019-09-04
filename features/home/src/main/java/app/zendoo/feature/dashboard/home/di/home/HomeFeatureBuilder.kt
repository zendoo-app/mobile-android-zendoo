package app.zendoo.feature.dashboard.home.di.home

import app.zendoo.feature.dashboard.home.ui.HomeFragment
import app.zendoo.feature.dashboard.home.di.loading.LoadingFeatureBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFeatureBuilder {

    //region HomeFragment

    @HomeScope
    @ContributesAndroidInjector(
        modules = [
            (HomeFragmentModule::class),
            (LoadingFeatureBuilder::class)
        ]
    )
    abstract fun homeFragment(): HomeFragment

    //endregion
}
