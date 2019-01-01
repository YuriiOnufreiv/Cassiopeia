package onufreiv.cassiopeia.activity

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import onufreiv.cassiopeia.*

class MainActivity : AppCompatActivity() {

	val POWER_COMMAND = "*"

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)

		fab.setOnClickListener {
			startActivity(Intent(this, PocMainActivity::class.java))
		}

		enableBluetooth()

		val modes = listOf(
				ModeData("VU Meter", "1", R.drawable.ic_volume, VuMeterActivity::class.java),
				ModeData("Rainbow", "2", R.drawable.ic_rainbow, RainbowActivity::class.java),
				ModeData("Strips", "3", R.drawable.ic_semaphore, StripsActivity::class.java),
				ModeData("Stroboscope", "6", R.drawable.ic_light_bulb, StroboscopeActivity::class.java),
				ModeData("Backlight", "7", R.drawable.ic_lamp, BacklightActivity::class.java),
				ModeData("Frequencies", "8", R.drawable.ic_studio_light, RunningFrequenciesActivity::class.java),
				ModeData("Spectrum", "9", R.drawable.ic_light_bulbs, SpectrumAnalyzerActivity::class.java)
		)

		recyclerview.layoutManager = GridLayoutManager(this, 3)
		recyclerview.adapter = ModeAdapter(this, modes)
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		menuInflater.inflate(R.menu.main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return when (item.itemId) {
			R.id.action_settings -> true
			R.id.action_power-> {
				BluetoothHandler.sendData(POWER_COMMAND)
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)

		if (requestCode == 0)
			when (resultCode) {
				Activity.RESULT_OK -> selectDevice()
			}
	}

	private fun enableBluetooth() {
		val turnOn = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
		startActivityForResult(turnOn, 0)
	}

	private fun selectDevice() {
		AlertDialog.Builder(this)
				.setAdapter(BluetoothDeviceAdapter(BluetoothHandler.getPairedDevicesList(), this)) { dialog, i ->
					val bluetoothDevice = (dialog as AlertDialog).listView.adapter.getItem(i) as BluetoothDevice
					BluetoothHandler.startConnection(bluetoothDevice)
				}
				.setTitle(getString(R.string.select_bluetooth_device))
				.create()
				.show()
	}
}
