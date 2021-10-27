package com.marcelo.ejemplo1fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class Fragment1 : Fragment() {
    private val model:transferirDatos by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var vista = inflater.inflate(R.layout.fragment1,container,false)
        vista.findViewById<Button>(R.id.boton).setOnClickListener {
        model.setItem(vista.findViewById<EditText>(R.id.editText).text.toString())

        }


        return vista
    }
}