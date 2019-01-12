package onufreiv.cassiopeia.arduino

class Command {
	enum class Mode(val value: String) {
		VU_METER("a"),
		RAINBOW("b"),
		STRIPS_FIVE("c"),
		STRIPS_THREE("d"),
		STRIPS_ONE_ALL("e"),
		STRIPS_ONE_LOW("f"),
		STRIPS_ONE_MEDIUM("g"),
		STRIPS_ONE_HIGH("h"),
		SPECTRUM("i"),
		BACKLIGHT_PERMANENT("j"),
		BACKLIGHT_CHANGING("k"),
		BACKLIGHT_RAINBOW("l"),
		FREQUENCIES_ALL("m"),
		FREQUENCIES_LOW("n"),
		FREQUENCIES_MEDIUM("o"),
		FREQUENCIES_HIGH("p"),
		STROBOSCOPE("q"),
		COMMON("@"),
		METEOR_RAIN_START_UP_EFFECT("0"),
		COLOR_WIPE_START_UP_EFFECT("1"),
		CYLON_BOUNCE_START_UP_EFFECT("2"),
		START_UP_EFFECT("")
	}

	enum class Settings(val value: String) {
		A_DEC("-"),
		A_INC("+"),
		B_DEC("<"),
		B_INC(">")
	}

	enum class Common(val value: String) {
		POWER("*"),
		NOISE_CALIBRATION("#")
	}
}