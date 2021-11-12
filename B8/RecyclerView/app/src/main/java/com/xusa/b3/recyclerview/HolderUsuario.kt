package com.xusa.b3.recyclerview

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HolderUsuario(itemView: View, i:Int, contexto: Context) : RecyclerView.ViewHolder(itemView),View.OnClickListener
{
    lateinit  var listerOnClick:PasarApellido

    var nombre: TextView
    var apellido: TextView
    init{
        nombre=itemView.findViewById(R.id.nombre)
        apellido=itemView.findViewById(R.id.apellido)

        apellido.setOnClickListener(this)
    }

    fun bind(usuario:Usuario)
    {
        nombre.text=usuario.nombre
        apellido.text=usuario.apellidos
    }

    fun apellidoOnClickListener(listener:View.OnClickListener)
    {
        listerOnClick=listener
    }
    override fun onClick(p0: View?) {
        listerOnClick.pasarApellido(apellido.text.toString())
    }
}
