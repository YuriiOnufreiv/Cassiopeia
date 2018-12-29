package onufreiv.cassiopeia.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import onufreiv.cassiopeia.BluetoothHandler
import onufreiv.cassiopeia.R

class StroboscopeActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_stroboscope)

		findViewById<View>(R.id.smoothness_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("r") }

		findViewById<View>(R.id.smoothness_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("l") }

		findViewById<View>(R.id.frequency_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("u") }

		findViewById<View>(R.id.frequency_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("d") }
	}
}
