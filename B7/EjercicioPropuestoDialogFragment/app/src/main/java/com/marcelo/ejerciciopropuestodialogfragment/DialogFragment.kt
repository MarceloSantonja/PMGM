package com.marcelo.ejerciciopropuestodialogfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class DialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val vista=inflater.inflate(R.layout.fragment_dialog,container,false)

        val botonCrear = vista.findViewById<Button>(R.id.crear_boton)
        val botonEntrar = vista.findViewById<Button>(R.id.entrar_boton)


        botonEntrar.setOnClickListener {

        }




        return inflater.inflate(R.layout.fragment_dialog, container, false)

    }







}