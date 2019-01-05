package onufreiv.cassiopeia.mode

import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.Command

object ModeService {

	fun getMainModes(): List<Mode> = listOf(getVuMeterMode(), getRainbowMode(), getStripsMode(),
			getStroboscopeMode(), getBacklightMode(), getFrequenciesMode(), getSpectrumMode())

	fun getMode(name: String): Mode {
		return getMainModes().first { it.name.equals(name) }
	}

	fun getVuMeterMode(): Mode {
		return Mode.Builder()
				.name("VU Meter")
				.command(Command.ONE)
				.icon(R.drawable.ic_volume)
				.settings(horSettings("Smoothness"))
				.noSubModes()
				.build()
	}

	fun getRainbowMode(): Mode {
		return Mode.Builder()
				.name("Rainbow")
				.command(Command.TWO)
				.icon(R.drawable.ic_rainbow)
				.settings(horSettings("Smoothness"), verSettings("Speed"))
				.noSubModes()
				.build()
	}

	fun getStripsMode(): Mode {
		return Mode.Builder()
				.name("Strips")
				.command(Command.THREE)
				.icon(R.drawable.ic_semaphore)
				.settings(horSettings("Smoothness"), verSettings("Sensitivity"))
				.subModes(getOneStripMode(), getThreeStripsMode(), getFiveStripsMode())
				.build()
	}

	fun getStroboscopeMode(): Mode {
		return Mode.Builder()
				.name("Stroboscope")
				.command(Command.SIX)
				.icon(R.drawable.ic_light_bulb)
				.settings(horSettings("Smoothness"), verSettings("Frequency"))
				.noSubModes()
				.build()
	}

	fun getBacklightMode(): Mode {
		return Mode.Builder()
				.name("Backlight")
				.command(Command.SEVEN)
				.icon(R.drawable.ic_lamp)
				.settings(horSettings("Color/Speed"), verSettings("Saturation/Rainbow step"))
				.subModes(getPermanentBacklightMode(), getChangingBacklightMode(), getRainbowBacklightMode())
				.build()
	}

	fun getFrequenciesMode(): Mode {
		return Mode.Builder()
				.name("Frequencies")
				.command(Command.EIGHT)
				.icon(R.drawable.ic_studio_light)
				.settings(horSettings("Speed"), verSettings("Sensitivity"))
				.subModes(getAllFrequenciesSubMode(), getLowFrequenciesSubMode(),
						getMediumFrequenciesSubMode(), getHighFrequenciesSubMode())
				.build()
	}

	fun getSpectrumMode(): Mode {
		return Mode.Builder()
				.name("Spectrum")
				.command(Command.SEVEN)
				.icon(R.drawable.ic_light_bulbs)
				.settings(horSettings("Color Step"), verSettings("Color"))
				.noSubModes()
				.build()
	}

	private fun getAllFrequenciesStripSubMode(): Mode {
		return Mode.Builder()
				.name("All")
				.command(Command.HASH)
				.build()
	}

	private fun getLowFrequenciesStripSubMode(): Mode {
		return Mode.Builder()
				.name("Low")
				.command(Command.HASH)
				.build()
	}

	private fun getMediumFrequenciesStripSubMode(): Mode {
		return Mode.Builder()
				.name("Medium")
				.command(Command.HASH)
				.build()
	}

	private fun getHighFrequenciesStripSubMode(): Mode {
		return Mode.Builder()
				.name("High")
				.command(Command.HASH)
				.build()
	}

	private fun getOneStripMode(): Mode {
		return Mode.Builder()
				.name("1 Strip")
				.command(Command.FIVE)
				.subModes(getAllFrequenciesStripSubMode(), getLowFrequenciesStripSubMode(),
						getMediumFrequenciesStripSubMode(), getHighFrequenciesStripSubMode())
				.build()
	}

	private fun getThreeStripsMode(): Mode {
		return Mode.Builder()
				.name("3 Strips")
				.command(Command.FOUR)
				.build()
	}

	private fun getFiveStripsMode(): Mode {
		return Mode.Builder()
				.name("5 Strips")
				.command(Command.THREE)
				.build()
	}

	private fun getPermanentBacklightMode(): Mode {
		return Mode.Builder()
				.name("Permanent")
				.command(Command.HASH)
				.settings(horSettings("Color"), verSettings("Saturation"))
				.noSubModes()
				.build()
	}

	private fun getChangingBacklightMode(): Mode {
		return Mode.Builder()
				.name("Changing")
				.command(Command.HASH)
				.settings(horSettings("Speed"), verSettings("Saturation"))
				.noSubModes()
				.build()
	}

	private fun getRainbowBacklightMode(): Mode {
		return Mode.Builder()
				.name("Rainbow")
				.command(Command.HASH)
				.settings(horSettings("Speed"), verSettings("Rainbow step"))
				.noSubModes()
				.build()
	}

	private fun getAllFrequenciesSubMode(): Mode {
		return Mode.Builder()
				.name("All")
				.command(Command.HASH)
				.build()
	}

	private fun getLowFrequenciesSubMode(): Mode {
		return Mode.Builder()
				.name("Low")
				.command(Command.HASH)
				.build()
	}

	private fun getMediumFrequenciesSubMode(): Mode {
		return Mode.Builder()
				.name("Medium")
				.command(Command.HASH)
				.build()
	}

	private fun getHighFrequenciesSubMode(): Mode {
		return Mode.Builder()
				.name("High")
				.command(Command.HASH)
				.build()
	}

	private fun verSettings(name: String): Settings {
		return Settings.VerBuilder()
				.name(name)
				.build()
	}

	private fun horSettings(name: String): Settings {
		return Settings.HorBuilder()
				.name(name)
				.build()
	}
}