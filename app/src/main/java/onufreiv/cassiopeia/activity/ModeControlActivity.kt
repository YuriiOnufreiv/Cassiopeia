package onufreiv.cassiopeia.activity

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.widget.Toolbar
import onufreiv.cassiopeia.ModeSettingsHelper.showModeSettings
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.SubModesHelper.showPrimarySubModes
import onufreiv.cassiopeia.mode.Mode
import onufreiv.cassiopeia.mode.ModeService

class ModeControlActivity : AppCompatActivity() {

	companion object {
		const val EXTRA_KEY_MODE = "mode"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_mode_control)

		val mode = getSelectedMode()
		val modeControlLayout = findViewById<ConstraintLayout>(R.id.mode_control_layout)

//		showModeNameOnToolbar(mode)
		showModeSettings(this, modeControlLayout, mode)
		showPrimarySubModes(this, modeControlLayout, mode)
	}

	private fun getSelectedMode(): Mode {
		val modeName = intent.extras[EXTRA_KEY_MODE]
		return ModeService.getMode(modeName as String)
	}

	private fun showModeNameOnToolbar(mode: Mode) {
		findViewById<Toolbar>(R.id.toolbar).title = mode.name
	}
}
