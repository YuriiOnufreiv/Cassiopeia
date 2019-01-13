package onufreiv.cassiopeia.activity

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_splash_screen.*
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.adapter.BluetoothDeviceAdapter
import onufreiv.cassiopeia.arduino.BluetoothDevicesObserver
import onufreiv.cassiopeia.prefs.arduinoLed
import onufreiv.cassiopeia.prefs.prefs
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class SplashScreenActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash_screen)

		retry_button.setOnClickListener {
			tryToConnect()
		}

		tryToConnect()
	}

	private fun tryToConnect() {
		progressBar.visibility = View.VISIBLE
		retry_button.visibility = View.INVISIBLE
		status_textView.text = "Establishing connection"
		enableBluetooth()
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)

		if (requestCode == 0)
			when (resultCode) {
				Activity.RESULT_OK -> startBluetoothConnection()
				Activity.RESULT_CANCELED -> failedToConnect()
			}
	}

	private fun enableBluetooth() {
		startActivityForResult(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 0)
	}

	private fun startBluetoothConnection() {
		if (prefs.bluetoothAddress.isNotEmpty())
			establishConnection()
		else
			selectDevice()
	}

	private fun selectDevice() {
		AlertDialog.Builder(this)
				.setAdapter(BluetoothDeviceAdapter(
						BluetoothDevicesObserver.getBonded(), this)
				) { dialog, i ->
					val bluetoothDevice = (dialog as AlertDialog).listView.adapter.getItem(i) as BluetoothDevice
					prefs.bluetoothAddress = bluetoothDevice.address
					establishConnection()
				}
				.setTitle(getString(R.string.select_bluetooth_device))
				.create()
				.show()
	}

	private fun establishConnection() {
		doAsync {
			val connected = arduinoLed.connect()

			uiThread {
				if (connected) {
					startActivity(Intent(applicationContext, MainModeSelectorActivity::class.java))
					finish()
				} else failedToConnect()
			}
		}
	}

	private fun failedToConnect() {
		progressBar.visibility = View.INVISIBLE
		retry_button.visibility = View.VISIBLE
		status_textView.text = "Failed to connect :("
	}
}
