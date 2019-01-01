package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.Command

class BacklightActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_backlight)

		val subModeButton = findViewById<View>(R.id.sub_mode_button)
		subModeButton.setOnClickListener { BluetoothHandler.sendCommand(Command.HASH) }

		findViewById<View>(R.id.color_speed_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.LEFT) }

		findViewById<View>(R.id.color_speed_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.RIGHT) }

		findViewById<View>(R.id.saturation_rainbow_step_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.UP) }

		findViewById<View>(R.id.saturation_rainbow_step_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.DOWN) }
	}
}
