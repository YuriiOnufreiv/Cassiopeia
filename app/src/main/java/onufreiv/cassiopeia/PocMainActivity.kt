package onufreiv.cassiopeia

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View

class PocMainActivity : AppCompatActivity() {

    private val bluetoothHandler = BluetoothHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poc_main)
        setButtonsOnClickListeners()

        turnOnBluetooth()
        selectDevice()
    }

    private fun setButtonsOnClickListeners() {
        findViewById<View>(R.id.one).setOnClickListener { bluetoothHandler.sendData("1") }
        findViewById<View>(R.id.two).setOnClickListener { bluetoothHandler.sendData("2") }
        findViewById<View>(R.id.three).setOnClickListener { bluetoothHandler.sendData("3") }
        findViewById<View>(R.id.four).setOnClickListener { bluetoothHandler.sendData("4") }
        findViewById<View>(R.id.five).setOnClickListener { bluetoothHandler.sendData("5") }
        findViewById<View>(R.id.six).setOnClickListener { bluetoothHandler.sendData("6") }
        findViewById<View>(R.id.seven).setOnClickListener { bluetoothHandler.sendData("7") }
        findViewById<View>(R.id.eight).setOnClickListener { bluetoothHandler.sendData("8") }
        findViewById<View>(R.id.nine).setOnClickListener { bluetoothHandler.sendData("9") }
        findViewById<View>(R.id.zero).setOnClickListener { bluetoothHandler.sendData("0") }
        findViewById<View>(R.id.star).setOnClickListener { bluetoothHandler.sendData("*") }
        findViewById<View>(R.id.bar).setOnClickListener { bluetoothHandler.sendData("#") }
        findViewById<View>(R.id.up).setOnClickListener { bluetoothHandler.sendData("u") }
        findViewById<View>(R.id.down).setOnClickListener { bluetoothHandler.sendData("d") }
        findViewById<View>(R.id.left).setOnClickListener { bluetoothHandler.sendData("l") }
        findViewById<View>(R.id.right).setOnClickListener { bluetoothHandler.sendData("r") }
        findViewById<View>(R.id.ok).setOnClickListener { bluetoothHandler.sendData("o") }
        findViewById<View>(R.id.connect).setOnClickListener { bluetoothHandler.startConnection() }
        findViewById<View>(R.id.disconnect).setOnClickListener { bluetoothHandler.closeConnection() }
    }

    private fun turnOnBluetooth() {
        val turnOn = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        startActivityForResult(turnOn, 0)
    }

    private fun selectDevice() {
        AlertDialog.Builder(this)
                .setAdapter(BluetoothDeviceAdapter(bluetoothHandler.getPairedDevicesList(), this)) { dialog, i ->
                    bluetoothHandler.bluetoothDevice =
                            (dialog as AlertDialog).listView.adapter.getItem(i) as BluetoothDevice?
                }
                .setTitle(getString(R.string.select_bluetooth_device))
                .create()
                .show()
    }
}
