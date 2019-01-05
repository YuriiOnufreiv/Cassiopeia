package onufreiv.cassiopeia

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.widget.Button
import android.widget.LinearLayout
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.mode.Mode

object SubModesHelper {

	fun showPrimarySubModes(context: Context,
	                        modeControlLayout: ConstraintLayout,
	                        mode: Mode) {

		val primarySubModesLayout = modeControlLayout
				.getViewById(R.id.primary_sub_modes) as LinearLayout

		mode.subModes.orEmpty().forEach { subMode ->
			val button = Button(context)
			button.text = subMode.name
			button.setOnClickListener {
				BluetoothHandler.sendCommand(subMode.command!!)

				if (subMode.settings.orEmpty().isNotEmpty())
					ModeSettingsHelper.showModeSettings(context, modeControlLayout, subMode)

				fillLayoutWithSecondarySubModes(context, modeControlLayout, subMode)
			}
			button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 1f)
			primarySubModesLayout.addView(button)
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
				BluetoothHandler.sendCommand(subMode.command!!)

				if (subMode.settings.orEmpty().isNotEmpty())
					ModeSettingsHelper.showModeSettings(context, generalModeLayout, subMode)
			}
			button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT, 1f)
			secondarySubModesLayout.addView(button)
		}
	}
}
