package app.zendoo.feature.dashboard.home.di.starting

import app.zendoo.feature.dashboard.home.di.StateScope
import app.zendoo.feature.dashboard.home.ui.starting.StartingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class StartingFeatureBuilder {

    //region LoadingFragment

    @StateScope
    @ContributesAndroidInjector(modules = [(StartingFragmentModule::class)])
    abstract fun startFragment(): StartingFragment

    //endregion
}
