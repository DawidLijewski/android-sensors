package lijewski.sensorsapp.di.module

import android.content.Context
import android.hardware.Sensor
import com.github.pwittchen.reactivesensors.library.ReactiveSensorEvent
import com.github.pwittchen.reactivesensors.library.ReactiveSensorFilter
import com.github.pwittchen.reactivesensors.library.ReactiveSensors
import dagger.Module
import dagger.Provides
import io.reactivex.Flowable
import io.reactivex.functions.Predicate
import javax.inject.Named
import javax.inject.Singleton

@Module
class SensorModule {
    companion object {
        const val GYROSCOPE = "gyroscope"
        const val ACCELEROMETER = "accelerometer"
        const val AMBIENT_TEMPERATURE = "ambient_temperature"
        const val LIGHT = "light"
        const val STEP = "step"
    }

    @Provides
    @Singleton
    @Named(GYROSCOPE)
    fun provideGyroscopeFlowable(reactiveSensors: ReactiveSensors): Flowable<ReactiveSensorEvent> {
        return reactiveSensors.observeSensor(Sensor.TYPE_GYROSCOPE)
    }

    @Provides
    @Singleton
    @Named(ACCELEROMETER)
    fun provideAccelerometerFlowable(reactiveSensors: ReactiveSensors): Flowable<ReactiveSensorEvent> {
        return reactiveSensors.observeSensor(Sensor.TYPE_ACCELEROMETER)
    }

    @Provides
    @Singleton
    @Named(AMBIENT_TEMPERATURE)
    fun provideTemperatureFlowable(reactiveSensors: ReactiveSensors): Flowable<ReactiveSensorEvent> {
        return reactiveSensors.observeSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
    }

    @Provides
    @Singleton
    @Named(LIGHT)
    fun provideLightFlowable(reactiveSensors: ReactiveSensors): Flowable<ReactiveSensorEvent> {
        return reactiveSensors.observeSensor(Sensor.TYPE_LIGHT)
    }

    @Provides
    @Singleton
    @Named(STEP)
    fun provideStepFlowable(reactiveSensors: ReactiveSensors): Flowable<ReactiveSensorEvent> {
        return reactiveSensors.observeSensor(Sensor.TYPE_STEP_COUNTER)
    }

    @Provides
    fun provideReactiveSensors(context: Context): ReactiveSensors {
        return ReactiveSensors(context)
    }

    @Provides
    fun provideSensorFilter(): Predicate<ReactiveSensorEvent> {
        return ReactiveSensorFilter.filterSensorChanged()
    }
}
