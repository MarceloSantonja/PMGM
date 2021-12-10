package com.ejemplos.b8.ejemplorecyclerviewV2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView

class HoldelUsuario(itemView: View): RecyclerView.ViewHolder(itemView)
{
    var nombre:TextView
    var apellido:TextView
    var imagen:ImageView
    init{
        nombre=itemView.findViewById(R.id.textView)
        apellido=itemView.findViewById(R.id.textView2)
        imagen=itemView.findViewById(R.id.imagen)
    }
    fun bind(dato:Usuario, tracker: SelectionTracker<Long>?)
    {
        nombre.text=dato.nombre
        apellido.text=dato.apellidos
        if(tracker!!.isSelected(adapterPosition.toLong())) {
            imagen.setImageResource(android.R.drawable.star_big_on)
            imagen.visibility=View.VISIBLE
        }
        else    imagen.visibility=View.INVISIBLE
    }
  /*  fun getItemDetaixls(): ItemDetailsLookup.ItemDetails<Long> =
        object: ItemDetailsLookup.ItemDetails<Long>() {
            override fun getPosition(): Int=adapterPosition
            override fun getSelectionKey(): Long? =itemId
        }*/

    fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> {
        var obj=object:ItemDetailsLookup.ItemDetails<Long>()
        {
              override fun getPosition(): Int {
                  return adapterPosition
              }
              override fun getSelectionKey(): Long? {
                  return itemId
              }
        }
        return obj
        }


}