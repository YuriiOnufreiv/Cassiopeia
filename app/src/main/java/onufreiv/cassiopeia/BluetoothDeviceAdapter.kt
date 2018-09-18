package onufreiv.cassiopeia

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class BluetoothDeviceAdapter(private val deviceList: List<BluetoothDevice>,
                             context: Context) : BaseAdapter() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView
                ?: layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false)

        val textView = view.findViewById(android.R.id.text1) as TextView
        textView.text = getItem(position).name

        return view
    }

    override fun getItem(position: Int): BluetoothDevice {
        return deviceList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return deviceList.size
    }
}