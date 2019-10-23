package lijewski.sensorsapp.presentation.light

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import lijewski.sensorsapp.app.R
import lijewski.sensorsapp.app.databinding.LightSensorFragmentBinding
import lijewski.sensorsapp.presentation.BaseSensorFragment

class LightSensorFragment: BaseSensorFragment() {
    companion object {
        const val TAG: String = "LightSensorFragment"
    }

    private lateinit var lightSensorViewModel: LightSensorViewModel

    private lateinit var binding: LightSensorFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lightSensorViewModel = ViewModelProviders.of(this, viewModelFactory).get(LightSensorViewModel::class.java)

        binding = DataBindingUtil.inflate<LightSensorFragmentBinding>(
            inflater, R.layout.light_sensor_fragment, container, false
        ).apply {
            viewModel = lightSensorViewModel
            lifecycleOwner = this@LightSensorFragment
        }

        return binding.root
    }
}
