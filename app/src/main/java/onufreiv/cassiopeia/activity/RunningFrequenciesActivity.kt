package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onufreiv.cassiopeia.BluetoothHandler
import onufreiv.cassiopeia.R

class RunningFrequenciesActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_running_frequencies)

		val subModeButton = findViewById<View>(R.id.sub_mode_button)
		subModeButton.setOnClickListener { BluetoothHandler.sendData("#") }

		findViewById<View>(R.id.speed_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("l") }

		findViewById<View>(R.id.speed_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("r") }

		findViewById<View>(R.id.sensitivity_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("u") }

		findViewById<View>(R.id.sensitivity_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("d") }
	}
}
