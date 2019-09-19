package app.zendoo.feature.player.di.player

import app.zendoo.feature.player.di.loading.LoadingFeatureBuilder
import app.zendoo.feature.player.ui.PlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PlayerFeatureBuilder {

    //region PlayerFragment

    @PlayerScope
    @ContributesAndroidInjector(
        modules = [
            (LoadingFeatureBuilder::class),
            (PlayerFragmentModule::class)
        ]
    )
    abstract fun playerFragment(): PlayerFragment

    //endregion
}
