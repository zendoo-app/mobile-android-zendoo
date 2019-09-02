package app.zendoo.namaste.di

import androidx.lifecycle.ViewModel
import app.zendoo.di.viewmodel.ViewModelKey
import app.zendoo.namaste.ui.ContainerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ContainerActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContainerViewModel::class)
    internal abstract fun homeViewModel(viewModel: ContainerViewModel): ViewModel
}
