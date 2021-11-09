package com.xusa.b3.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adaptador( datos:ArrayList<Usuario>, var contexto: Context): RecyclerView.Adapter<HolderUsuario>() {

     lateinit var datos:ArrayList<Usuario>
     init {
         this.datos=datos
     }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderUsuario {
       var view= LayoutInflater.from(parent.context)
           .inflate(R.layout.linea_recycler, parent, false)
        var holderUsuario=HolderUsuario(view,0,contexto)
        return holderUsuario
    }

    override fun onBindViewHolder(holder: HolderUsuario, position: Int) {
      holder.bind(datos.get(position))
    }

    override fun getItemCount(): Int {
       return datos.size
    }
}