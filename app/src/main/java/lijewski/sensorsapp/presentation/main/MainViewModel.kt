package lijewski.sensorsapp.presentation.main

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import lijewski.sensorsapp.di.module.RxModule
import javax.inject.Inject
import javax.inject.Named

class MainViewModel @Inject constructor(
    @Named(RxModule.IO) private val ioScheduler: Scheduler,
    @Named(RxModule.MAIN) private val mainScheduler: Scheduler
) : ViewModel() {
    private val disposables = CompositeDisposable()
    val isLoading = ObservableBoolean(false)

    override fun onCleared() {
        disposables.clear()
    }

}
