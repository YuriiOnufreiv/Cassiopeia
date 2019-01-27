package onufreiv.cassiopeia.arduino

import onufreiv.cassiopeia.mode.Mode
import onufreiv.cassiopeia.prefs

class ArduinoLed {

	private val bluetoothHandler = ArduinoLedBluetoothHandler()

	fun turnOnMode(mode: Mode) {
		enableMode(mode)
		prefs.activeMode = mode.name!!
	}

	fun turnOnSubMode(mode: Mode, subMode: Mode) {
		enableMode(subMode)
		prefs.saveActiveSubMode(mode, subMode)
	}

	private fun enableMode(mode: Mode) {
		val subModeCommand = getSubModeToEnable(mode)
		bluetoothHandler.sendCommand(subModeCommand!!)
	}

	private fun getSubModeToEnable(mode: Mode): Command.Mode? {
		val modeToEnable = mode.subModes.orEmpty()
				.asSequence()
				.filter { it.name == prefs.getActiveSubMode(mode) }
				.firstOrNull()

		if (modeToEnable != null) return getSubModeToEnable(modeToEnable)

		return mode.command!!
	}

	fun sendSettingsCommand(settingsCommand: Command.Settings) {
		bluetoothHandler.sendCommand(settingsCommand)
	}

	fun connect(): Boolean {
		return bluetoothHandler.connect()
	}

	fun disconnect() {
		bluetoothHandler.disconnect()
	}

	fun sendCommand(command: Command.Common) {
		bluetoothHandler.sendCommand(command)
	}

	fun sendCommand(command: Command.Mode) {
		bluetoothHandler.sendCommand(command)
	}
}