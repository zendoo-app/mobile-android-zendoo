package app.zendoo.namaste.di

import app.zendoo.feature.dashboard.di.DashboardFeatureBuilder
import app.zendoo.feature.player.di.PlayerFeatureBuilder
import app.zendoo.namaste.ui.ContainerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    //region ContainerActivity

    @ContainerScope
    @ContributesAndroidInjector(
        modules = [
            (ContainerViewModelModule::class),
            (DashboardFeatureBuilder::class),
            (PlayerFeatureBuilder::class)
        ]
    )
    abstract fun containerActivity(): ContainerActivity

    //endregion
}
