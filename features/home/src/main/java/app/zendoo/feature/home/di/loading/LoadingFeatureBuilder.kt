package app.zendoo.feature.home.di.loading

import app.zendoo.feature.home.di.StateScope
import app.zendoo.feature.home.di.start.StartFragmentModule
import app.zendoo.feature.home.ui.loading.LoadingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoadingFeatureBuilder {

    //region LoadingFragment

    @StateScope
    @ContributesAndroidInjector(modules = [(StartFragmentModule::class)])
    abstract fun loadingFragment(): LoadingFragment

    //endregion
}
