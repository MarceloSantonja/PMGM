package com.ejemplos.b8.ejemplorecyclerviewV2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView

class Adaptador(var datos:ArrayList<Usuario> ): RecyclerView.Adapter<HoldelUsuario>() {

    private  lateinit var tracker: SelectionTracker<Long>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoldelUsuario {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.linea_recyclerl,
            parent,false)

        var holdelUsuario=HoldelUsuario(view)
        return holdelUsuario
    }

    fun setTracker(tracker:SelectionTracker<Long>)
    {
        this.tracker=tracker
    }
    override fun onBindViewHolder(holder: HoldelUsuario, position: Int) {
        holder.bind(datos.get(position),tracker)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return  datos.size
    }
}