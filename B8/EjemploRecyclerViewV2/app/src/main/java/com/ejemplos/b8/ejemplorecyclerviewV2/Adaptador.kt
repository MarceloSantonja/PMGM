package com.ejemplos.b8.ejemplorecyclerviewV2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView


class Adaptador internal constructor(val datos: ArrayList<Usuario>, val context: Context) :
    RecyclerView.Adapter<Holder>(){
    lateinit var listenerClick:View.OnClickListener;
    private var tracker: SelectionTracker<Long>? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Holder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recyclerlayout, viewGroup, false)

        return Holder(itemView,context)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item: Usuario = datos[position]
        holder.bind(item,tracker!!)
    }
    override fun getItemCount(): Int {
        return datos.size
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    fun setTracker(tracker: SelectionTracker<Long>?) {
        if (tracker != null) {
            this.tracker = tracker
        }
    }


}
