package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R

class BacklightActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_backlight)

		val subModeButton = findViewById<View>(R.id.sub_mode_button)
		subModeButton.setOnClickListener { BluetoothHandler.sendData("#") }

		findViewById<View>(R.id.color_speed_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("l") }

		findViewById<View>(R.id.color_speed_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("r") }

		findViewById<View>(R.id.saturation_rainbow_step_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("u") }

		findViewById<View>(R.id.saturation_rainbow_step_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("d") }
	}
}
