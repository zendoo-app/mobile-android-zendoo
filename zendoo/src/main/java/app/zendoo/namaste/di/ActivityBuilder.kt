package app.zendoo.namaste.di

import app.zendoo.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    //region ContainerActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(ContainerActivityModule::class)])
    abstract fun containerActivityModule(): ContainerActivityModule

    //endregion
}