package lijewski.sensorsapp.presentation.step

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import lijewski.sensorsapp.app.R
import lijewski.sensorsapp.app.databinding.StepSensorFragmentBinding
import lijewski.sensorsapp.presentation.BaseSensorFragment

class StepSensorFragment: BaseSensorFragment() {
    companion object {
        const val TAG: String = "StepSensorFragment"
    }

    private lateinit var stepSensorViewModel: StepSensorViewModel

    private lateinit var binding: StepSensorFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        stepSensorViewModel = ViewModelProviders.of(this, viewModelFactory).get(StepSensorViewModel::class.java)

        binding = DataBindingUtil.inflate<StepSensorFragmentBinding>(
            inflater, R.layout.light_sensor_fragment, container, false
        ).apply {
            viewModel = stepSensorViewModel
            lifecycleOwner = this@StepSensorFragment
        }

        return binding.root
    }
}
