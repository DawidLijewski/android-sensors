package lijewski.sensorsapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lijewski.sensorsapp.di.factory.ViewModelFactory
import lijewski.sensorsapp.di.key.ViewModelKey
import lijewski.sensorsapp.presentation.main.MainViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: MainViewModel): ViewModel
}
