package app.zendoo.namaste.di

import androidx.lifecycle.ViewModel
import app.zendoo.di.viewmodel.ViewModelKey
import app.zendoo.di.viewmodel.ViewModelModule
import app.zendoo.feature.dashboard.di.DashboardViewModelModule
import app.zendoo.namaste.ui.ZendooViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        (ViewModelModule::class),
        (DashboardViewModelModule::class)
    ]
)
abstract class ContainerViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ZendooViewModel::class)
    internal abstract fun containerViewModel(viewModel: ZendooViewModel): ViewModel
}
