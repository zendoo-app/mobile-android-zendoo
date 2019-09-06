package app.zendoo.feature.dashboard.home.di.progressing

import app.zendoo.feature.dashboard.home.di.StateScope
import app.zendoo.feature.dashboard.home.ui.progressing.ProgressingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProgressingFeatureBuilder {

    //region LoadingFragment

    @StateScope
    @ContributesAndroidInjector(modules = [(ProgressingFragmentModule::class)])
    abstract fun startFragment(): ProgressingFragment

    //endregion
}
