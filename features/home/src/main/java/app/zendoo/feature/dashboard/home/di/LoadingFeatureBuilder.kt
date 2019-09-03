package app.zendoo.feature.dashboard.home.di

import app.zendoo.feature.dashboard.home.ui.LoadingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoadingFeatureBuilder {

    //region LoadingFragment

    @StateScope
    @ContributesAndroidInjector(modules = [(LoadingFragmentModule::class)])
    abstract fun loadingFragment(): LoadingFragment

    //endregion
}
