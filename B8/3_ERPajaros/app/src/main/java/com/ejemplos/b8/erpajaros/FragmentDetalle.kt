package com.ejemplos.b8.erpajaros

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment


// Este fragmento representa el detalle de la entrada seleccionada en la lista.
class FragmentDetalle : Fragment() {

    var mItem: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if(savedInstanceState!=null) mItem=savedInstanceState?.getInt("POSICION")
        else {
            if (arguments != null) {
                mItem = arguments?.getInt("POSICION")
            } else mItem = 0
        }
    }
    override  fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_detalle, container, false)
        //Mostramos el contenido al usuario
        if(MainActivity.datos!!.size > 0) {
            val elemento = MainActivity.datos?.get(mItem!!)
            (rootView.findViewById<TextView>(R.id.textView_superior)).text = elemento?.nombre
            (rootView.findViewById<TextView>(R.id.textView_inferior)).text = elemento?.desc
            (rootView.findViewById<ImageView>(R.id.imageView_imagen)).setImageResource(elemento!!.icono)
        }
        return rootView
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("POSICION", mItem!!)
    }
}