package onufreiv.cassiopeia.arduino

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice

object BluetoothDevicesObserver {

	fun getBonded(): List<BluetoothDevice> =
			BluetoothAdapter.getDefaultAdapter().bondedDevices.toList()
}