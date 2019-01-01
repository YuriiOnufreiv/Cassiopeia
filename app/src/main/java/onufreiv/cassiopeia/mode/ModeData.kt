package onufreiv.cassiopeia.mode

import android.support.v7.app.AppCompatActivity

data class ModeData(val mode: Mode,
                    val activity: Class<out AppCompatActivity>)