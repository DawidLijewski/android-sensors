package lijewski.sensorsapp.presentation.temperature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import lijewski.sensorsapp.app.R
import lijewski.sensorsapp.app.databinding.TemperatureSensorFragmentBinding
import lijewski.sensorsapp.presentation.BaseSensorFragment

class TemperatureSensorFragment: BaseSensorFragment() {
    companion object {
        const val TAG: String = "TemperatureSensorFragment"
    }

    private lateinit var temperatureSensorViewModel: TemperatureSensorViewModel

    private lateinit var binding: TemperatureSensorFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        temperatureSensorViewModel = ViewModelProviders.of(this, viewModelFactory).get(TemperatureSensorViewModel::class.java)

        binding = DataBindingUtil.inflate<TemperatureSensorFragmentBinding>(
            inflater, R.layout.temperature_sensor_fragment, container, false
        ).apply {
            viewModel = temperatureSensorViewModel
            lifecycleOwner = this@TemperatureSensorFragment
        }

        return binding.root
    }
}
