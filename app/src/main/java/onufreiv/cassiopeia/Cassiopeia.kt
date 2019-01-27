package onufreiv.cassiopeia

import android.app.Application
import onufreiv.cassiopeia.arduino.ArduinoLed
import onufreiv.cassiopeia.prefs.Preferences

val prefs: Preferences by lazy {
	Cassiopeia.prefs!!
}

val arduinoLed: ArduinoLed by lazy {
	Cassiopeia.arduinoLed
}

class Cassiopeia : Application() {
	companion object {
		var prefs: Preferences? = null
		var arduinoLed = ArduinoLed()
	}

	override fun onCreate() {
		prefs = Preferences(applicationContext)
		super.onCreate()
	}
}