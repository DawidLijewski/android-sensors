package lijewski.sensorsapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import lijewski.sensorsapp.presentation.main.MainFragment

@Suppress("unused")
@Module
abstract class MainModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}
