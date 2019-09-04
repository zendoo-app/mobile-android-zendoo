package app.zendoo.feature.dashboard.home.di.loading

import app.zendoo.feature.dashboard.home.di.StateScope
import app.zendoo.feature.dashboard.home.ui.loading.LoadingFragment
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
