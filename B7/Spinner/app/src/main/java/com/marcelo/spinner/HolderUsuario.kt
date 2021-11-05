package com.marcelo.spinner

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HolderUsuario(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var nombre : TextView
    var apellido : TextView
    init {
        nombre = itemView.findViewById(R.id.nombre)
        apellido = itemView.findViewById(R.id.apellido)
    }



}