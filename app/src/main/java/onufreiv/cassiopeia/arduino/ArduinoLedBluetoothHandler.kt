package onufreiv.cassiopeia.arduino

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import onufreiv.cassiopeia.prefs.prefs
import java.io.IOException
import java.util.*

class ArduinoLedBluetoothHandler {

	private val uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
	private val maxNumberOfAttempts = 3

	private lateinit var bluetoothSocket: BluetoothSocket

	fun connect(): Boolean {
		val arduinoBluetoothDevice = BluetoothAdapter.getDefaultAdapter()
				.getRemoteDevice(prefs.bluetoothAddress)

		var connected: Boolean
		var attempt = 1

		do {
			connected = connectToDevice(arduinoBluetoothDevice)
		} while (!connected && attempt++ < maxNumberOfAttempts)

		return connected
	}

	fun disconnect() {
		bluetoothSocket.outputStream.flush()
		bluetoothSocket.outputStream.close()
	}

	fun sendCommand(command: Command.Mode) {
		sendData(command.value)
	}

	fun sendCommand(command: Command.Settings) {
		sendData(command.value)
	}

	fun sendCommand(command: Command.Common) {
		sendData(command.value)
	}

	private fun connectToDevice(deviceToConnect: BluetoothDevice): Boolean {
		bluetoothSocket = deviceToConnect.createRfcommSocketToServiceRecord(uuid)
		BluetoothAdapter.getDefaultAdapter().cancelDiscovery()
		try {
			bluetoothSocket.connect()
		} catch (e: IOException) {
			BluetoothAdapter.getDefaultAdapter().startDiscovery()
			return false
		}
		return true
	}

	private fun sendData(data: String) {
		bluetoothSocket.outputStream.write(data.toByteArray())
	}
}