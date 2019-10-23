package lijewski.sensorsapp.presentation.accelerometer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import lijewski.sensorsapp.app.R
import lijewski.sensorsapp.app.databinding.AccelerometerFragmentBinding
import lijewski.sensorsapp.presentation.BaseSensorFragment

class AccelerometerFragment: BaseSensorFragment() {
    companion object {
        const val TAG: String = "AccelerometerFragment"
    }

    private lateinit var accelerometerViewModel: AccelerometerViewModel

    private lateinit var binding: AccelerometerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        accelerometerViewModel = ViewModelProviders.of(this, viewModelFactory).get(AccelerometerViewModel::class.java)

        binding = DataBindingUtil.inflate<AccelerometerFragmentBinding>(
            inflater, R.layout.accelerometer_fragment, container, false
        ).apply {
            viewModel = accelerometerViewModel
            lifecycleOwner = this@AccelerometerFragment
        }

        return binding.root
    }
}
