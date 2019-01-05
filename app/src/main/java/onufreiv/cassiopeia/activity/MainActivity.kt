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
import onufreiv.cassiopeia.adapter.BluetoothDeviceAdapter
import onufreiv.cassiopeia.adapter.ModeAdapter
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.arduino.Command
import onufreiv.cassiopeia.mode.ModeService

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)

		fab.setOnClickListener {
			startActivity(Intent(this, PocMainActivity::class.java))
		}

		enableBluetooth()

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
			R.id.action_settings -> true
			R.id.action_power -> {
				BluetoothHandler.sendCommand(Command.STAR)
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
