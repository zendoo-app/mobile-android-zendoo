package app.zendoo.feature.dashboard.home.di.start

import app.zendoo.feature.dashboard.home.di.StateScope
import app.zendoo.feature.dashboard.home.ui.start.StartFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class StartFeatureBuilder {

    //region LoadingFragment

    @StateScope
    @ContributesAndroidInjector(modules = [(StartFragmentModule::class)])
    abstract fun startFragment(): StartFragment

    //endregion
}
