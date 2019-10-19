package app.zendoo.feature.player.di.loading

import app.zendoo.feature.player.di.StateScope
import app.zendoo.feature.player.ui.loading.LoadingFragment
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
