package lijewski.sensorsapp.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import lijewski.sensorsapp.presentation.main.MainActivity

@Suppress("unused")
@Module
abstract class BuilderModule {
    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun bindMainActivity(): MainActivity
}
