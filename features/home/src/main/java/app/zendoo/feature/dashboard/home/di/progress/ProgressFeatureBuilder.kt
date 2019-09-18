package app.zendoo.feature.dashboard.home.di.progress

import app.zendoo.feature.dashboard.home.di.StateScope
import app.zendoo.feature.dashboard.home.ui.progress.ProgressFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProgressFeatureBuilder {

    //region LoadingFragment

    @StateScope
    @ContributesAndroidInjector(modules = [(ProgressFragmentModule::class)])
    abstract fun startFragment(): ProgressFragment

    //endregion
}
