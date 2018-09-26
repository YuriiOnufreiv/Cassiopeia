package onufreiv.cassiopeia

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

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
        holder.modeName.text = items[position].name
    }
}

class ModeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val modeName = view.mode_name_text_view!!
}