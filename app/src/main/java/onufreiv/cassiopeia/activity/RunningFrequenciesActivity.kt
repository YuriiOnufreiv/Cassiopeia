package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.Command

class RunningFrequenciesActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_running_frequencies)

		val subModeButton = findViewById<View>(R.id.sub_mode_button)
		subModeButton.setOnClickListener { BluetoothHandler.sendCommand(Command.HASH) }

		findViewById<View>(R.id.speed_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.LEFT) }

		findViewById<View>(R.id.speed_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.RIGHT) }

		findViewById<View>(R.id.sensitivity_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.UP) }

		findViewById<View>(R.id.sensitivity_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.DOWN) }
	}
}
