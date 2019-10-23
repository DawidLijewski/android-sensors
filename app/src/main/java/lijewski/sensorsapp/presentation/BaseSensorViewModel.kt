package lijewski.sensorsapp.presentation

import androidx.lifecycle.ViewModel
import com.github.pwittchen.reactivesensors.library.ReactiveSensorEvent
import com.github.pwittchen.reactivesensors.library.ReactiveSensors
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Predicate
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

abstract class BaseSensorViewModel constructor(
    private val reactiveSensors: ReactiveSensors,
    private val sensorFilter: Predicate<ReactiveSensorEvent>,
    private val sensorFlowable: Flowable<ReactiveSensorEvent>,
    private val computationScheduler: Scheduler,
    private val mainScheduler: Scheduler
) : ViewModel() {

    private val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
    }

    fun observeSensor() {
        sensorFlowable
            .subscribeOn(computationScheduler)
            .observeOn(mainScheduler)
            .filter(sensorFilter)
            .subscribe(this::handleSensorEvent, this::handleError)
            .addTo(disposables)
    }

    abstract fun handleSensorEvent(reactiveSensorEvent: ReactiveSensorEvent)

    open fun handleError(t: Throwable) {
        Timber.e(t)
    }

}
