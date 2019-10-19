package app.zendoo.namaste.di

import app.zendoo.feature.dashboard.di.DashboardFeatureBuilder
import app.zendoo.feature.player.di.player.PlayerFeatureBuilder
import app.zendoo.namaste.ui.ZendooActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    //region ContainerActivity

    @ZendooScope
    @ContributesAndroidInjector(
        modules = [
            (ZendooViewModelModule::class),
            (DashboardFeatureBuilder::class),
            (PlayerFeatureBuilder::class)
        ]
    )
    abstract fun containerActivity(): ZendooActivity

    //endregion
}
