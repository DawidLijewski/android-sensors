package lijewski.sensorsapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lijewski.sensorsapp.di.factory.ViewModelFactory
import lijewski.sensorsapp.di.key.ViewModelKey
import lijewski.sensorsapp.presentation.accelerometer.AccelerometerViewModel
import lijewski.sensorsapp.presentation.gyroscope.GyroscopeViewModel
import lijewski.sensorsapp.presentation.light.LightSensorViewModel
import lijewski.sensorsapp.presentation.main.MainViewModel
import lijewski.sensorsapp.presentation.temperature.TemperatureSensorViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GyroscopeViewModel::class)
    abstract fun bindGyroscopeViewModel(gyroscopeViewModel: GyroscopeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AccelerometerViewModel::class)
    abstract fun bindAccelerometerViewModel(accelerometerViewModel: AccelerometerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TemperatureSensorViewModel::class)
    abstract fun bindAmbientTemperatureViewModel(temperatureSensorViewModel: TemperatureSensorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LightSensorViewModel::class)
    abstract fun bindLightSensorViewModel(lightSensorViewModel: LightSensorViewModel): ViewModel
}
