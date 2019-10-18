package lijewski.sensorsapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import lijewski.sensorsapp.App

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }
}
