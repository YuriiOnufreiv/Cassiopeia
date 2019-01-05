package onufreiv.cassiopeia.activity

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import onufreiv.cassiopeia.adapter.BluetoothDeviceAdapter
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.R

class PocMainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_poc_main)
		setButtonsOnClickListeners()

		turnOnBluetooth()
		selectDevice()
	}

	private fun setButtonsOnClickListeners() {
		findViewById<View>(R.id.one).setOnClickListener { BluetoothHandler.sendData("1") }
		findViewById<View>(R.id.two).setOnClickListener { BluetoothHandler.sendData("2") }
		findViewById<View>(R.id.three).setOnClickListener { BluetoothHandler.sendData("3") }
		findViewById<View>(R.id.four).setOnClickListener { BluetoothHandler.sendData("4") }
		findViewById<View>(R.id.five).setOnClickListener { BluetoothHandler.sendData("5") }
		findViewById<View>(R.id.six).setOnClickListener { BluetoothHandler.sendData("6") }
		findViewById<View>(R.id.seven).setOnClickListener { BluetoothHandler.sendData("7") }
		findViewById<View>(R.id.eight).setOnClickListener { BluetoothHandler.sendData("8") }
		findViewById<View>(R.id.nine).setOnClickListener { BluetoothHandler.sendData("9") }
		findViewById<View>(R.id.zero).setOnClickListener { BluetoothHandler.sendData("0") }
		findViewById<View>(R.id.star).setOnClickListener { BluetoothHandler.sendData("*") }
		findViewById<View>(R.id.bar).setOnClickListener { BluetoothHandler.sendData("#") }
		findViewById<View>(R.id.up).setOnClickListener { BluetoothHandler.sendData("u") }
		findViewById<View>(R.id.down).setOnClickListener { BluetoothHandler.sendData("d") }
		findViewById<View>(R.id.left).setOnClickListener { BluetoothHandler.sendData("l") }
		findViewById<View>(R.id.right).setOnClickListener { BluetoothHandler.sendData("r") }
		findViewById<View>(R.id.ok).setOnClickListener { BluetoothHandler.sendData("o") }
//        findViewById<View>(R.id.connect).setOnClickListener { BluetoothHandler.startConnection() }
		findViewById<View>(R.id.disconnect).setOnClickListener { BluetoothHandler.closeConnection() }
	}

	private fun turnOnBluetooth() {
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
