package onufreiv.cassiopeia.activity.helper

import android.content.Context
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.widget.Button
import android.widget.LinearLayout
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduinoLed
import onufreiv.cassiopeia.mode.Mode
import onufreiv.cassiopeia.prefs

object SubModeLayoutProvider {

	fun showPrimarySubModes(context: Context,
	                        modeControlLayout: ConstraintLayout,
	                        mode: Mode) {

		val primarySubModesLayout = modeControlLayout
				.getViewById(R.id.primary_sub_modes) as LinearLayout

		mode.subModes.orEmpty().forEach { subMode ->
			val button = Button(context)
			button.text = subMode.name
			button.setOnClickListener {
				arduinoLed.turnOnSubMode(mode, subMode)
				highlightActiveSubMode(mode, primarySubModesLayout)

				if (subMode.settings.orEmpty().isNotEmpty())
					SettingsLayoutProvider.showModeSettings(context, modeControlLayout, subMode)

				fillLayoutWithSecondarySubModes(context, modeControlLayout, subMode)
			}
			button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 1f)
			primarySubModesLayout.addView(button)
		}

		highlightActiveSubMode(mode, primarySubModesLayout)
		if (prefs.getActiveSubMode(mode).isNotEmpty()) {
			val activeSecondarySubMode = mode.subModes.orEmpty()
					.first { it -> it.name == prefs.getActiveSubMode(mode) }
			fillLayoutWithSecondarySubModes(context, modeControlLayout, activeSecondarySubMode)
		}
	}

	private fun fillLayoutWithSecondarySubModes(context: Context,
	                                            generalModeLayout: ConstraintLayout,
	                                            subModeParam: Mode) {

		val secondarySubModesLayout = generalModeLayout
				.getViewById(R.id.secondary_sub_modes) as LinearLayout

		secondarySubModesLayout.removeAllViews()

		subModeParam.subModes.orEmpty().forEach { subMode ->
			val button = Button(context)
			button.text = subMode.name
			button.setOnClickListener {
				arduinoLed.turnOnSubMode(subModeParam, subMode)
				highlightActiveSubMode(subModeParam, secondarySubModesLayout)

				if (subMode.settings.orEmpty().isNotEmpty())
					SettingsLayoutProvider.showModeSettings(context, generalModeLayout, subMode)
			}
			button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 1f)
			secondarySubModesLayout.addView(button)
		}

		highlightActiveSubMode(subModeParam, secondarySubModesLayout)
	}

	private fun highlightActiveSubMode(mode: Mode, primarySubModesLayout: LinearLayout) {
		for (i in 0 until primarySubModesLayout.childCount) {
			val button = primarySubModesLayout.getChildAt(i) as Button
			if (prefs.getActiveSubMode(mode) == button.text) {
				button.setBackgroundColor(Color.parseColor("#3F51B5"))
				button.setTextColor(Color.WHITE)
			} else {
				button.setBackgroundColor(Color.LTGRAY)
				button.setTextColor(Color.BLACK)
			}
		}
	}
}
