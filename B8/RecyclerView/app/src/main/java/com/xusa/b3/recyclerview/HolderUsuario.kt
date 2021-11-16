package com.xusa.b3.recyclerview

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class HolderUsuario(itemView: View, i:Int, val contexto: Context) : RecyclerView.ViewHolder
    (itemView),View.OnClickListener, View.OnLongClickListener
{
    lateinit  var listerOnClick:PasarApellido
    lateinit var  listenerUsuario:PasarUsuario
    var usuari:Usuario? = null

    var nombre: TextView
    var apellido: TextView
    init{
        nombre=itemView.findViewById(R.id.nombre)
        apellido=itemView.findViewById(R.id.apellido)

        apellido.setOnClickListener(this)
        apellido.setOnLongClickListener(this)
    }

    fun bind(usuario:Usuario, posicion:Int)
    {

        if(posicion%2==0) itemView.findViewById<CardView>(R.id.cardView).setCardBackgroundColor(ContextCompat
            .getColor(contexto,android.R
            .color.holo_blue_dark))
        else
            itemView.findViewById<CardView>(R.id.cardView).setCardBackgroundColor(ContextCompat
                .getColor(contexto, R.color.purple_200))
        usuari=usuario
        nombre.text=usuario.nombre
        apellido.text=usuario.apellidos
    }

    fun apellidoOnClickListener(listener:PasarApellido)
    {
        listerOnClick=listener
    }

    fun apellidoOnLongListener(listener:PasarUsuario)
    {
        listenerUsuario= listener
    }
    override fun onClick(p0: View?) {
        listerOnClick.pasarApellido(apellido.text.toString())
    }

    override fun onLongClick(p0: View?): Boolean {
       listenerUsuario.pasarUsuario(usuari!!)
        return true
    }
}
