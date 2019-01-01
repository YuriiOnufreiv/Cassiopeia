package onufreiv.cassiopeia.mode

import onufreiv.cassiopeia.arduino.Command
import onufreiv.cassiopeia.R

enum class Mode(val id: String,
                val icon: Int,
                val command: Command) {
	VU_METER("VU Meter", R.drawable.ic_volume, Command.ONE),
	RAINBOW("Rainbow", R.drawable.ic_rainbow, Command.TWO),
	STRIPS("Strips", R.drawable.ic_semaphore, Command.THREE),
	STROBOSCOPE("Stroboscope", R.drawable.ic_light_bulb, Command.SIX),
	BACKLIGHT("Backlight", R.drawable.ic_lamp, Command.SEVEN),
	FREQUENCIES("Frequencies", R.drawable.ic_studio_light, Command.EIGHT),
	SPECTRUM("Spectrum", R.drawable.ic_light_bulbs, Command.NINE)
}