package app.zendoo.namaste.di

import app.zendoo.di.ActivityScope
import app.zendoo.feature.dashboard.di.DashboardFeatureBuilder
import app.zendoo.namaste.ui.ContainerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        (DashboardFeatureBuilder::class)
    ]
)
abstract class ZendooBuilder {

    //region ContainerActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ContainerActivityModule::class)])
    abstract fun containerActivity(): ContainerActivity

    //endregion

}
