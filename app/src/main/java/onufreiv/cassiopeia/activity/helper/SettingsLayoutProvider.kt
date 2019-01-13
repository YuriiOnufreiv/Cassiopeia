package onufreiv.cassiopeia.activity.helper

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import kotlinx.android.synthetic.main.mode_settings.view.*
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.mode.Mode
import onufreiv.cassiopeia.mode.Settings
import onufreiv.cassiopeia.arduinoLed

object SettingsLayoutProvider {

	fun showModeSettings(context: Context,
	                     modeControlLayout: ConstraintLayout,
	                     mode: Mode) {

		val settingsLayout = modeControlLayout
				.getViewById(R.id.mode_settings) as LinearLayout
		settingsLayout.removeAllViews()

		settingsLayout.addView(createModeSettingsLayout(context, mode))
	}

	fun createModeSettingsLayout(context: Context, mode: Mode): LinearLayout {
		val linearLayout = createEmptyLayout(context)

		mode.settings.orEmpty().forEach {
			val singleSettingsLayout = createSingleSettingsLayout(context, it)
			linearLayout.addView(singleSettingsLayout)
		}

		return linearLayout
	}

	private fun createEmptyLayout(context: Context): LinearLayout {
		val linearLayout = LinearLayout(context)
		linearLayout.layoutParams = LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT,
				1f
		)
		linearLayout.orientation = LinearLayout.VERTICAL
		return linearLayout
	}

	private fun createSingleSettingsLayout(context: Context,
	                                       settings: Settings): View? {

		val modeSettingsLayout = LayoutInflater.from(context)
				.inflate(R.layout.mode_settings, null)

		modeSettingsLayout.settings_name.text = settings.name
		modeSettingsLayout.settings_decrease_button.setOnClickListener {
			arduinoLed.sendCommand(settings.decreaseCommand)
		}
		modeSettingsLayout.settings_increase_button.setOnClickListener {
			arduinoLed.sendCommand(settings.increaseCommand)
		}
		return modeSettingsLayout
	}
}
