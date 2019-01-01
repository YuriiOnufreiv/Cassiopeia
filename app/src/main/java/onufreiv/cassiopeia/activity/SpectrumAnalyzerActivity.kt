package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.Command

class SpectrumAnalyzerActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_spectrum_analyzer)

		findViewById<View>(R.id.color_step_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.RIGHT) }

		findViewById<View>(R.id.color_step_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.LEFT) }

		findViewById<View>(R.id.color_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.UP) }

		findViewById<View>(R.id.color_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.DOWN) }
	}
}
