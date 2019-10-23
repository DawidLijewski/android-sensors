package lijewski.sensorsapp.presentation.accelerometer

import com.github.pwittchen.reactivesensors.library.ReactiveSensorEvent
import com.github.pwittchen.reactivesensors.library.ReactiveSensors
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.functions.Predicate
import lijewski.sensorsapp.di.module.RxModule
import lijewski.sensorsapp.di.module.SensorModule
import lijewski.sensorsapp.presentation.BaseSensorViewModel
import timber.log.Timber
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class AccelerometerViewModel @Inject constructor(
    reactiveSensors: ReactiveSensors,
    sensorFilter: Predicate<ReactiveSensorEvent>,
    @Named(SensorModule.ACCELEROMETER) private val sensorFlowable: Flowable<ReactiveSensorEvent>,
    @Named(RxModule.COMPUTATION) private val computationScheduler: Scheduler,
    @Named(RxModule.MAIN) private val mainScheduler: Scheduler
) : BaseSensorViewModel(
    reactiveSensors,
    sensorFilter,
    sensorFlowable,
    computationScheduler,
    mainScheduler
) {
    override fun handleSensorEvent(reactiveSensorEvent: ReactiveSensorEvent) {
        val event = reactiveSensorEvent.sensorEvent

        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]

        val format = "%s readings:\n x = %f\n y = %f\n z = %f"
        val message = String.format(Locale.getDefault(), format, SensorModule.AMBIENT_TEMPERATURE, x, y, z)
        Timber.d(message)
    }
}
