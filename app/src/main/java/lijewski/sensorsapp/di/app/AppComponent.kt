package lijewski.sensorsapp.di.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import lijewski.sensorsapp.App
import lijewski.sensorsapp.di.module.AppModule
import lijewski.sensorsapp.di.module.BuilderModule
import lijewski.sensorsapp.di.module.RxModule
import lijewski.sensorsapp.di.module.SensorModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        BuilderModule::class,
        RxModule::class,
        SensorModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>
}
