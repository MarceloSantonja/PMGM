package com.ejemplos.b8.erpajaros

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class Adapter(var datos: ArrayList<Datos>) : RecyclerView.Adapter<Adapter.Holder>(),
    View.OnClickListener, OnLongClickListener {
    var listener: View.OnClickListener? = null
    var listenerLong: OnLongClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View
        view = LayoutInflater.from(parent.context).inflate(R.layout.elemento_lista, parent, false)
        val holder = Holder(view)
        view.setOnClickListener(this)
        view.setOnLongClickListener(this)
        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        (holder as Holder?)!!.bind(datos[position])
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    fun miOnClick(listener: View.OnClickListener?) {
        this.listener = listener
    }

    override fun onClick(v: View) {
        if (listener != null) listener!!.onClick(v)
    }

    fun miOnLongClick(listener: OnLongClickListener?) {
        listenerLong = listener
    }

    override fun onLongClick(v: View): Boolean {
        if (listenerLong != null) listenerLong!!.onLongClick(v)
        return false
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var lineTexto: TextView
        var imagen: ImageView
        var cardView: CardView
        fun bind(dato: Datos) {
            lineTexto.text = dato.nombre
            imagen.setImageResource(dato.icono)
        }

        init {
            lineTexto = itemView.findViewById(R.id.textView_titulo)
            imagen = itemView.findViewById(R.id.imageView_imagen_miniatura)
            cardView = itemView.findViewById(R.id.cardView)
        }
    }
}
