package onufreiv.cassiopeia.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.mode_item_row.view.*
import onufreiv.cassiopeia.R
import onufreiv.cassiopeia.activity.ModeControlActivity
import onufreiv.cassiopeia.arduinoLed
import onufreiv.cassiopeia.mode.Mode
import onufreiv.cassiopeia.prefs

class ModeAdapter(private val context: Context,
                  private val items: List<Mode>)
	: RecyclerView.Adapter<ModeViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeViewHolder {
		return ModeViewHolder(LayoutInflater.from(context)
				.inflate(R.layout.mode_item_row, parent, false))
	}

	override fun getItemCount(): Int {
		return items.size
	}

	override fun onBindViewHolder(holder: ModeViewHolder, position: Int) {
		val mode = items[position]

		highlightActiveMode(mode, holder)

		holder.modeNameTextView.text = mode.name
		holder.modeIconImageView.setImageResource(mode.icon!!)
		holder.cardView.setOnClickListener {
			startModeControlActivity(mode)
			arduinoLed.turnOnMode(mode)
			notifyDataSetChanged()
		}
	}

	private fun highlightActiveMode(mode: Mode, holder: ModeViewHolder) {
		if (prefs.activeMode == mode.name) {
			holder.modeIconImageView.setBackgroundColor(Color.parseColor("#f8fde3"))
			holder.modeNameTextView.setBackgroundColor(Color.parseColor("#FFE9FBBB"))
		} else {
			holder.modeIconImageView.setBackgroundColor(Color.parseColor("#E3F2FD"))
			holder.modeNameTextView.setBackgroundColor(Color.parseColor("#BBDEFB"))
		}
	}

	private fun startModeControlActivity(mode: Mode) {
		val intent = Intent(context, ModeControlActivity::class.java)
		intent.putExtra(ModeControlActivity.EXTRA_KEY_MODE, mode.name)
		context.startActivity(intent)
	}
}

class ModeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
	val modeNameTextView = view.mode_name_text_view!!
	val modeIconImageView = view.mode_icon_image_view!!
	val cardView = view.mode_card_view!!
}