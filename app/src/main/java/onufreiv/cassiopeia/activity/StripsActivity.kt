package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.Command

class StripsActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_strips)

		val subModeButton = findViewById<View>(R.id.sub_mode_button)
		subModeButton.visibility = INVISIBLE
		subModeButton.setOnClickListener { BluetoothHandler.sendCommand(Command.HASH) }

		findViewById<View>(R.id.smoothness_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.RIGHT) }

		findViewById<View>(R.id.smoothness_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.LEFT) }

		findViewById<View>(R.id.sensitivity_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.UP) }

		findViewById<View>(R.id.sensitivity_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.DOWN) }

		findViewById<View>(R.id.five_strips_button)
				.setOnClickListener {
					BluetoothHandler.sendCommand(Command.THREE)
					subModeButton.visibility = INVISIBLE
				}

		findViewById<View>(R.id.three_strips_button)
				.setOnClickListener {
					BluetoothHandler.sendCommand(Command.FOUR)
					subModeButton.visibility = INVISIBLE
				}

		findViewById<View>(R.id.one_strip_button)
				.setOnClickListener {
					BluetoothHandler.sendCommand(Command.FIVE)
					subModeButton.visibility = VISIBLE
				}
	}
}
