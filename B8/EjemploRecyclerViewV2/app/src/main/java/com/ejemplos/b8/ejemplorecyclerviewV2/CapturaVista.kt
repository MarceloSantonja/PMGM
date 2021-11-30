package com.ejemplos.b8.ejemplorecyclerviewV2

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class CapturaVista(var rv:RecyclerView): ItemDetailsLookup<Long>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view =rv.findChildViewUnder(e.x, e.y)
        if(view != null) {
            return (rv.getChildViewHolder(view) as Holder).getItemDetails()
        }
        return null
    }
}