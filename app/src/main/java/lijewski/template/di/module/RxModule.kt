package lijewski.template.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class RxModule {
    companion object {
        const val MAIN = "main"
        const val IO = "io"
        const val COMPUTATION = "computation"
        const val TRAMPOLINE = "trampoline"
    }

    @Provides
    @Singleton
    @Named(MAIN)
    internal fun provideMainScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    @Named(IO)
    internal fun provideIoScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Singleton
    @Named(COMPUTATION)
    internal fun provideComputationScheduler(): Scheduler {
        return Schedulers.computation()
    }

    @Provides
    @Singleton
    @Named(TRAMPOLINE)
    internal fun provideTrampolineScheduler(): Scheduler {
        return Schedulers.trampoline()
    }
}
