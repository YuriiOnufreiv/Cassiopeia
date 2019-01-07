package onufreiv.cassiopeia.mode

import onufreiv.cassiopeia.arduino.Command

class Settings private constructor(val name: String?,
                                   val decreaseCommand: Command.Settings,
                                   val increaseCommand: Command.Settings) {

	data class HorBuilder(var name: String? = null,
	                      var decreaseCommand: Command.Settings = Command.Settings.A_DEC,
	                      var increaseCommand: Command.Settings = Command.Settings.A_INC) {

		fun name(name: String) = apply { this.name = name }

		fun build() = Settings(name, decreaseCommand, increaseCommand)
	}

	data class VerBuilder(var name: String? = null,
	                      var decreaseCommand: Command.Settings = Command.Settings.B_DEC,
	                      var increaseCommand: Command.Settings = Command.Settings.B_INC) {

		fun name(name: String) = apply { this.name = name }

		fun build() = Settings(name, decreaseCommand, increaseCommand)
	}
}