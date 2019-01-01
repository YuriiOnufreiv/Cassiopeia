package onufreiv.cassiopeia.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.Command

class RainbowActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_rainbow)

		findViewById<View>(R.id.smoothness_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.RIGHT) }

		findViewById<View>(R.id.smoothness_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.LEFT) }

		findViewById<View>(R.id.speed_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.UP) }

		findViewById<View>(R.id.speed_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.DOWN) }
	}
}
