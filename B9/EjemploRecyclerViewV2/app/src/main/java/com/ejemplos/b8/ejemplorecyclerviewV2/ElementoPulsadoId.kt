package com.ejemplos.b8.ejemplorecyclerviewV2

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class ElementoPulsadoId(var recycler: RecyclerView):ItemDetailsLookup<Long>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view=recycler.findChildViewUnder(e.x, e.y)
        if(view!=null)
        {
            return (recycler.getChildViewHolder(view) as HoldelUsuario).getItemDetails()
        }
        return  null
    }
}

