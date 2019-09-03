package app.zendoo.feature.dashboard.di

import androidx.lifecycle.ViewModel
import app.zendoo.di.viewmodel.ViewModelKey
import app.zendoo.feature.dashboard.DashboardViewModel
import app.zendoo.feature.dashboard.home.di.HomeFragmentModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        (HomeFragmentModule::class)
    ]
)
abstract class DashboardViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    internal abstract fun dashboardViewModel(viewModel: DashboardViewModel): ViewModel
}
