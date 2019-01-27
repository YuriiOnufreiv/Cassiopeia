package onufreiv.cassiopeia.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main_mode_selector.*
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.activity.helper.SettingsLayoutProvider
import onufreiv.cassiopeia.adapter.ModeAdapter
import onufreiv.cassiopeia.arduino.Command
import onufreiv.cassiopeia.mode.ModeService
import onufreiv.cassiopeia.arduinoLed

class MainModeSelectorActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main_mode_selector)
		setSupportActionBar(toolbar)

		val mainModes = ModeService.getMainModes()

		recyclerview.layoutManager = GridLayoutManager(this, 3)
		recyclerview.adapter = ModeAdapter(this, mainModes)
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		menuInflater.inflate(R.menu.main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.action_power -> {
				processPowerActionClick()
				true
			}
			R.id.action_brightness -> {
				processBrightnessActionClick()
				true
			}
			R.id.action_calibrate -> {
				processCalibrateActionClick()
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}

	override fun onBackPressed() {
		super.onBackPressed()
		arduinoLed.disconnect()
	}

	private fun processCalibrateActionClick() {
		AlertDialog.Builder(this)
				.setTitle("Calibrate")
				.setMessage("Do you want to perform calibration?")
				.setPositiveButton("OK") { _, _ ->
					arduinoLed.sendCommand(Command.Common.NOISE_CALIBRATION)
				}
				.setNegativeButton("No") { _, _ -> }
				.show()
	}

	private fun processBrightnessActionClick() {
		val generalMode = ModeService.getModeWithCommonSettings()
		val command = generalMode.command!!
		arduinoLed.sendCommand(command)
		AlertDialog.Builder(this)
				.setTitle("Brightness")
				.setView(SettingsLayoutProvider
						.createModeSettingsLayout(this, generalMode))
				.setPositiveButton("OK") { _, _ ->
					arduinoLed.sendCommand(command)
				}
				.setOnCancelListener { arduinoLed.sendCommand(command) }
				.show()
	}

	private fun processPowerActionClick() {
		arduinoLed.sendCommand(Command.Common.POWER)
	}
}
