package onufreiv.cassiopeia

import android.app.Application
import onufreiv.cassiopeia.arduino.ArduinoLedBluetoothHandler
import onufreiv.cassiopeia.prefs.Preferences

val prefs: Preferences by lazy {
	Cassiopeia.prefs!!
}

val arduinoLed: ArduinoLedBluetoothHandler by lazy {
	Cassiopeia.arduinoLedBluetoothHandler!!
}

class Cassiopeia : Application() {
	companion object {
		var prefs: Preferences? = null
		var arduinoLedBluetoothHandler = ArduinoLedBluetoothHandler()
	}

	override fun onCreate() {
		prefs = Preferences(applicationContext)
		super.onCreate()
	}
}