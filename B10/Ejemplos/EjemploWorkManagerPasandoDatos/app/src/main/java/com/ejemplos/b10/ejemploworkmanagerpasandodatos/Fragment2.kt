package com.ejemplos.b10.ejemploworkmanagerpasandodatos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment2(var salida: String) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dos, container, false)
        view.findViewById<TextView>(R.id.texto).text = salida +"\n Has entrado al sistema"
        return view
    }
}