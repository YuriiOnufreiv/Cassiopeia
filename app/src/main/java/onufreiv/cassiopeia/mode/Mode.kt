package onufreiv.cassiopeia.mode

import onufreiv.cassiopeia.arduino.Command

class Mode private constructor(val name: String?,
                               val command: Command.Mode?,
                               val icon: Int?,
                               val settings: List<Settings>?,
                               val subModes: List<Mode>?) {

	data class Builder(var name: String? = null,
	                   var command: Command.Mode? = null,
	                   var icon: Int? = null,
	                   var settings: List<Settings>? = null,
	                   var subModes: List<Mode>? = null) {

		fun name(name: String) = apply { this.name = name }

		fun command(command: Command.Mode) = apply { this.command = command }

		fun icon(icon: Int) = apply { this.icon = icon }

		fun settings(vararg settings: Settings) = apply { this.settings = settings.asList() }

		fun subModes(vararg subModes: Mode) = apply { this.subModes = subModes.asList() }

		fun noSubModes() = apply { this.subModes = emptyList() }

		fun build() = Mode(name, command, icon, settings, subModes)
	}
}