package onufreiv.cassiopeia

import onufreiv.cassiopeia.Command.*

enum class Mode(val id: String,
                val icon: Int,
                val command: Command) {
	VU_METER("VU Meter", R.drawable.ic_volume, ONE),
	RAINBOW("Rainbow", R.drawable.ic_rainbow, TWO),
	STRIPS("Strips", R.drawable.ic_semaphore, THREE),
	STROBOSCOPE("Stroboscope", R.drawable.ic_light_bulb, SIX),
	BACKLIGHT("Backlight", R.drawable.ic_lamp, SEVEN),
	FREQUENCIES("Frequencies", R.drawable.ic_studio_light, EIGHT),
	SPECTRUM("Spectrum", R.drawable.ic_light_bulbs, NINE)
}