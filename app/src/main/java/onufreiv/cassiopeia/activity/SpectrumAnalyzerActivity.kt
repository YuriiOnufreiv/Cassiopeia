package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R

class SpectrumAnalyzerActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_spectrum_analyzer)

		findViewById<View>(R.id.color_step_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("r") }

		findViewById<View>(R.id.color_step_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("l") }

		findViewById<View>(R.id.color_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("u") }

		findViewById<View>(R.id.color_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("d") }
	}
}
