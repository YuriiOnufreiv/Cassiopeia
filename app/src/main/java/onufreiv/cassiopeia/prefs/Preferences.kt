package onufreiv.cassiopeia.prefs

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Preferences(context: Context) {
	private val defaultPrefValue = ""

	private val prefsFilename = "onufreyiv.cassiopeia.prefs"
	private val _bluetoothAddress = "bluetooth_address"

	private val prefs: SharedPreferences =
			context.getSharedPreferences(prefsFilename, MODE_PRIVATE)

	var bluetoothAddress: String
		get() = readPref(_bluetoothAddress)
		set(value) = savePref(_bluetoothAddress, value)

	private fun readPref(prefName: String): String {
		return prefs.getString(prefName, defaultPrefValue)
	}

	private fun savePref(prefName: String, prefValue: String) {
		prefs.edit().putString(prefName, prefValue).apply()
	}
}