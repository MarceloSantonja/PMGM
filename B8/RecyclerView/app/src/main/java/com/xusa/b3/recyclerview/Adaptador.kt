package com.xusa.b3.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adaptador( datos:ArrayList<Usuario>, var contexto: Context): RecyclerView.Adapter<HolderUsuario>(),View.OnClickListener {
     lateinit var clickListener:View.OnClickListener
     lateinit var datos:ArrayList<Usuario>
     init {
         this.datos=datos
     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderUsuario {
       var view= LayoutInflater.from(parent.context)
           .inflate(R.layout.linea_recycler, parent, false)
        var holderUsuario=HolderUsuario(view,0,contexto)
        view.setOnClickListener(this)
        return holderUsuario
    }
    override fun onBindViewHolder(holder: HolderUsuario, position: Int) {
      holder.bind(datos.get(position))
    }
    override fun getItemCount(): Int {
       return datos.size
    }
    fun PulsarItemListener(listener:View.OnClickListener)
    {
        clickListener=listener
    }
    override fun onClick(p0: View?) {
        clickListener.onClick(p0)
    }
}