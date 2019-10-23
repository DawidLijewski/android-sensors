package lijewski.sensorsapp.presentation.gyroscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import lijewski.sensorsapp.app.R
import lijewski.sensorsapp.app.databinding.GyroscopeFragmentBinding
import lijewski.sensorsapp.presentation.BaseSensorFragment

class GyroscopeFragment: BaseSensorFragment() {
    companion object {
        const val TAG: String = "GyroscopeFragment"
    }

    private lateinit var gyroscopeViewModel: GyroscopeViewModel

    private lateinit var binding: GyroscopeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gyroscopeViewModel = ViewModelProviders.of(this, viewModelFactory).get(GyroscopeViewModel::class.java)

        binding = DataBindingUtil.inflate<GyroscopeFragmentBinding>(
            inflater, R.layout.accelerometer_fragment, container, false
        ).apply {
            viewModel = gyroscopeViewModel
            lifecycleOwner = this@GyroscopeFragment
        }

        return binding.root
    }
}
