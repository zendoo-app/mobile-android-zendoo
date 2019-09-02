package app.zendoo.feature.dashboard.home.di

import app.zendoo.di.FragmentScope
import app.zendoo.feature.dashboard.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
    ]
)
abstract class HomeFeatureBuilder {

    //region HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [(HomeFragmentModule::class)])
    abstract fun homeFragment(): HomeFragment

    //endregion

}
