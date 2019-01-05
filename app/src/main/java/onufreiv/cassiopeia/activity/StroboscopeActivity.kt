package onufreiv.cassiopeia.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.Command

class StroboscopeActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_stroboscope)

		findViewById<View>(R.id.smoothness_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.RIGHT) }

		findViewById<View>(R.id.smoothness_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.LEFT) }

		findViewById<View>(R.id.frequency_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.UP) }

		findViewById<View>(R.id.frequency_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.DOWN) }
	}
}
