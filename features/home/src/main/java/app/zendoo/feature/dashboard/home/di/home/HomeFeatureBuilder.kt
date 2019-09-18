package app.zendoo.feature.dashboard.home.di.home

import app.zendoo.feature.dashboard.home.di.loading.LoadingFeatureBuilder
import app.zendoo.feature.dashboard.home.di.progress.ProgressFeatureBuilder
import app.zendoo.feature.dashboard.home.di.start.StartFeatureBuilder
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
            (StartFeatureBuilder::class),
            (ProgressFeatureBuilder::class)
        ]
    )
    abstract fun homeFragment(): HomeFragment

    //endregion
}
