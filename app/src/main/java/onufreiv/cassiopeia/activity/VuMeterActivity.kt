package onufreiv.cassiopeia.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.Command

class VuMeterActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_vu_meter)

		findViewById<View>(R.id.smoothness_icr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.RIGHT) }

		findViewById<View>(R.id.smoothness_dcr_button)
				.setOnClickListener { BluetoothHandler.sendCommand(Command.LEFT) }
	}
}
