package onufreiv.cassiopeia.activity.helper

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.mode_settings.view.*
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.mode.Mode
import onufreiv.cassiopeia.mode.Settings

object SettingsLayoutProvider {

	fun showModeSettings(context: Context,
	                             modeControlLayout: ConstraintLayout,
	                             mode: Mode) {

		val settingsLayout = modeControlLayout
				.getViewById(R.id.mode_settings) as LinearLayout
		settingsLayout.removeAllViews()

		mode.settings.orEmpty().forEach {
			val singleSettingsLayout = createSingleSettingsLayout(context, it)
			settingsLayout.addView(singleSettingsLayout)
		}
	}

	private fun createSingleSettingsLayout(context: Context,
	                                       settings: Settings): View? {

		val modeSettingsLayout = LayoutInflater.from(context)
				.inflate(R.layout.mode_settings, null)

		modeSettingsLayout.settings_name.text = settings.name
		modeSettingsLayout.settings_decrease_button.setOnClickListener {
			BluetoothHandler.sendCommand(settings.decreaseCommand!!)
		}
		modeSettingsLayout.settings_increase_button.setOnClickListener {
			BluetoothHandler.sendCommand(settings.increaseCommand!!)
		}
		return modeSettingsLayout
	}
}
