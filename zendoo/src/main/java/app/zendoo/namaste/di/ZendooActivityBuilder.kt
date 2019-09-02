package app.zendoo.namaste.di

import app.zendoo.di.scope.ActivityScope
import app.zendoo.feature.dashboard.di.DashboardFeatureBuilder
import app.zendoo.namaste.ui.ContainerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [

    ]
)
abstract class ZendooActivityBuilder {

    //region ContainerActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            (DashboardFeatureBuilder::class)
        ]
    )
    abstract fun containerActivity(): ContainerActivity

    //endregion
}
