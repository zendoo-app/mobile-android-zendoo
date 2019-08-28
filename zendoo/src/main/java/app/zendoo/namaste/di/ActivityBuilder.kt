package app.zendoo.namaste.di

import app.zendoo.di.ActivityScope
import app.zendoo.namaste.ui.ContainerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    //region ContainerActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ContainerActivityModule::class)])
    abstract fun containerActivity(): ContainerActivity

    //endregion
}
