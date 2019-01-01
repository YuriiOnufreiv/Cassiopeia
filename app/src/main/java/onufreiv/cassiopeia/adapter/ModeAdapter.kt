package onufreiv.cassiopeia.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import onufreiv.cassiopeia.arduino.BluetoothHandler
import onufreiv.cassiopeia.mode.ModeData
import onufreiv.cassiopeia.R

class ModeAdapter(private val context: Context,
                  private val items: List<ModeData>)
	: RecyclerView.Adapter<ModeViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeViewHolder {
		return ModeViewHolder(LayoutInflater.from(context)
				.inflate(R.layout.recyclerview_item_row, parent, false))
	}

	override fun getItemCount(): Int {
		return items.size
	}

	override fun onBindViewHolder(holder: ModeViewHolder, position: Int) {
		val modeData = items[position]

		holder.modeNameTextView.text = modeData.mode.id
		holder.modeIconImageView.setImageResource(modeData.mode.icon)
		holder.cardView.setOnClickListener {
			BluetoothHandler.sendData(modeData.mode.command.value)
			context.startActivity(Intent(context, modeData.activity))
		}
	}
}

class ModeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
	val modeNameTextView = view.mode_name_text_view!!
	val modeIconImageView = view.mode_icon_image_view!!
	val cardView = view.mode_card_view!!
}