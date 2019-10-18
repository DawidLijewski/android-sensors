package lijewski.sensorsapp.app.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.schedulers.Schedulers
import lijewski.sensorsapp.presentation.main.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testScheduler = Schedulers.trampoline()
    private lateinit var sut: MainViewModel

    @Before
    fun setUp() {
        sut = MainViewModel(testScheduler, testScheduler)
    }

    @Test
    fun `viewmodel empty test`() {

    }
}
