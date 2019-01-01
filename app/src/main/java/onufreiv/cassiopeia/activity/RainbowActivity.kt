package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R

class RainbowActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_rainbow)

		findViewById<View>(R.id.smoothness_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("r") }

		findViewById<View>(R.id.smoothness_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("l") }

		findViewById<View>(R.id.speed_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("u") }

		findViewById<View>(R.id.speed_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("d") }
	}
}
