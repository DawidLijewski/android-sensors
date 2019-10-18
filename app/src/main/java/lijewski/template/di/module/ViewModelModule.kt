package lijewski.template.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lijewski.template.di.factory.ViewModelFactory
import lijewski.template.di.key.ViewModelKey
import lijewski.template.presentation.main.MainViewModel

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
