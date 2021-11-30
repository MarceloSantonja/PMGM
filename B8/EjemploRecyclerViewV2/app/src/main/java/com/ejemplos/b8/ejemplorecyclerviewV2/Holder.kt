package com.ejemplos.b8.ejemplorecyclerviewV2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView


class Holder(v: View, context: Context) : RecyclerView.ViewHolder(v) {
    val textNombre: TextView
    val textApellido: TextView
    val context: Context
    val imagen: ImageView

    fun bind(entity: Usuario, t: SelectionTracker<Long>) {
        textNombre.setText(entity.nombre)
        textApellido.setText(entity.apellidos)
        if(t.isSelected(adapterPosition.toLong()))
            imagen.setImageResource(android.R.drawable.star_big_on)
        else
            imagen.setImageResource(android.R.drawable.star_big_off)


    }

    init {
        this.context = context
        textNombre = v.findViewById(R.id.textView)
        textApellido = v.findViewById(R.id.textView2)
        imagen = v.findViewById(R.id.imagen)
    }
   /* fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
        object: ItemDetailsLookup.ItemDetails<Long>() {
            override fun getPosition(): Int=adapterPosition
            override fun getSelectionKey(): Long? =itemId
        }*/
   fun  getItemDetails():ItemDetailsLookup.ItemDetails<Long>{
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