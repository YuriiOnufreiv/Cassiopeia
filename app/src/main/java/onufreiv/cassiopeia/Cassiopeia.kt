package onufreiv.cassiopeia

import android.app.Application

val prefs: Preferences by lazy {
	Cassiopeia.prefs!!
}

class Cassiopeia : Application() {
	companion object {
		var prefs: Preferences? = null
	}

	override fun onCreate() {
		prefs = Preferences(applicationContext)
		super.onCreate()
	}
}