package app.zendoo.feature.dashboard.home.di

import app.zendoo.feature.dashboard.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFeatureBuilder {

    //region HomeFragment

    @HomeScope
    @ContributesAndroidInjector(modules = [(HomeFragmentModule::class)])
    abstract fun homeFragment(): HomeFragment

    //endregion
}
