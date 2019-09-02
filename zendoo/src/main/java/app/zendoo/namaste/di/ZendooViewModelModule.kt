package app.zendoo.namaste.di

import androidx.lifecycle.ViewModelProvider
import app.zendoo.di.viewmodel.ViewModelFactory
import app.zendoo.feature.dashboard.di.DashboardViewModelModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        (DashboardViewModelModule::class)
    ]
)
abstract class ZendooViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
