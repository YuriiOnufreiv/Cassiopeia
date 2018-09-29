package onufreiv.cassiopeia

import android.support.v7.app.AppCompatActivity

data class ModeData(val name: String,
                    val command: String,
                    val icon: Int,
                    val activity: Class<out AppCompatActivity>)