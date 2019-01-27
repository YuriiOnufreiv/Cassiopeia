package onufreiv.cassiopeia.prefs

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import onufreiv.cassiopeia.mode.Mode

class Preferences(context: Context) {
	private val defaultPrefValue = ""

	private val prefsFilename = "onufreyiv.cassiopeia.prefs"
	private val _bluetoothAddress = "bluetooth_address"
	private val _activeMode = "active_mode"

	private val prefs: SharedPreferences =
			context.getSharedPreferences(prefsFilename, MODE_PRIVATE)

	var bluetoothAddress: String
		get() = readPref(_bluetoothAddress)
		set(value) = savePref(_bluetoothAddress, value)

	var activeMode: String
		get() = readPref(_activeMode)
		set(value) = savePref(_activeMode, value)

	fun saveActiveSubMode(mode: Mode, subMode: Mode) {
		val key = """${mode.name}#subMode"""
		val value = subMode.name
		savePref(key, value!!)
	}

	fun getActiveSubMode(mode: Mode): String {
		return readPref("""${mode.name}#subMode""")
	}

	private fun readPref(prefName: String): String {
		return prefs.getString(prefName, defaultPrefValue)
	}

	private fun savePref(prefName: String, prefValue: String) {
		prefs.edit().putString(prefName, prefValue).apply()
	}
}