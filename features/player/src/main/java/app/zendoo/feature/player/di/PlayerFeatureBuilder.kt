package app.zendoo.feature.player.di

import app.zendoo.feature.player.ui.PlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PlayerFeatureBuilder {

    //region PlayerFragment

    @PlayerScope
    @ContributesAndroidInjector(
        modules = [
            (PlayerFragmentModule::class)
        ]
    )
    abstract fun playerFragment(): PlayerFragment

    //endregion
}
