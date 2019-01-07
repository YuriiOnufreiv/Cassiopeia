package onufreiv.cassiopeia.arduino

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import java.io.OutputStream
import java.util.*

object BluetoothHandler {

	private val uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
	private val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

	private lateinit var bluetoothSocket: BluetoothSocket
	private lateinit var outputStream: OutputStream

	private lateinit var bluetoothDevice: BluetoothDevice

	fun getPairedDevicesList(): List<BluetoothDevice> = bluetoothAdapter.bondedDevices.toList()

	fun sendCommand(command: Command.Mode) {
		sendData(command.value)
	}

	fun sendCommand(command: Command.Settings) {
		sendData(command.value)
	}

	fun sendCommand(command: Command.Common) {
		sendData(command.value)
	}

	fun startConnection(deviceToConnect: BluetoothDevice) {
		bluetoothDevice = deviceToConnect

		bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuid)
		bluetoothAdapter.cancelDiscovery()
		bluetoothSocket.connect()
		outputStream = bluetoothSocket.outputStream
	}

	fun closeConnection() {
		outputStream.flush()
		outputStream.close()
	}

	private fun sendData(message: String) {
		val data = message.toByteArray()
		outputStream.write(data)
	}
}