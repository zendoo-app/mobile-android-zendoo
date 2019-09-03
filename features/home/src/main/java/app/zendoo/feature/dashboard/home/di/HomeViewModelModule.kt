package app.zendoo.feature.dashboard.home.di

import androidx.lifecycle.ViewModel
import app.zendoo.di.viewmodel.ViewModelKey
import app.zendoo.feature.dashboard.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel
}
