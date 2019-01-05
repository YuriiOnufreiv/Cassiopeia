package onufreiv.cassiopeia.mode

import onufreiv.cassiopeia.arduino.Command

class Settings private constructor(val name: String?,
                                   val decreaseCommand: Command?,
                                   val increaseCommand: Command?) {

	data class HorBuilder(var name: String? = null,
	                      var decreaseCommand: Command = Command.LEFT,
	                      var increaseCommand: Command = Command.RIGHT) {

		fun name(name: String) = apply { this.name = name }

		fun build() = Settings(name, decreaseCommand, increaseCommand)
	}

	data class VerBuilder(var name: String? = null,
	                      var decreaseCommand: Command = Command.DOWN,
	                      var increaseCommand: Command = Command.UP) {

		fun name(name: String) = apply { this.name = name }

		fun build() = Settings(name, decreaseCommand, increaseCommand)
	}
}