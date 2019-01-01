package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R

class StripsActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_strips)

		val subModeButton = findViewById<View>(R.id.sub_mode_button)
		subModeButton.visibility = INVISIBLE
		subModeButton.setOnClickListener { BluetoothHandler.sendData("#") }

		findViewById<View>(R.id.smoothness_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("r") }

		findViewById<View>(R.id.smoothness_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("l") }

		findViewById<View>(R.id.sensitivity_icr_button)
				.setOnClickListener { BluetoothHandler.sendData("u") }

		findViewById<View>(R.id.sensitivity_dcr_button)
				.setOnClickListener { BluetoothHandler.sendData("d") }

		findViewById<View>(R.id.five_strips_button)
				.setOnClickListener {
					BluetoothHandler.sendData("3")
					subModeButton.visibility = INVISIBLE
				}

		findViewById<View>(R.id.three_strips_button)
				.setOnClickListener {
					BluetoothHandler.sendData("4")
					subModeButton.visibility = INVISIBLE
				}

		findViewById<View>(R.id.one_strip_button)
				.setOnClickListener {
					BluetoothHandler.sendData("5")
					subModeButton.visibility = VISIBLE
				}
	}
}
