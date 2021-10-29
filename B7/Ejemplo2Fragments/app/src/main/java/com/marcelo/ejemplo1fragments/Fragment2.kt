package com.marcelo.ejemplo1fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer


class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var bundle: Bundle? = arguments
        super.onCreateView(inflater, container, savedInstanceState)
        var vista = inflater.inflate(R.layout.fragment2, container, false)
        vista.findViewById<TextView>(R.id.texto).text = bundle?.getString("DATO")

        //  val model:transferirDatos by activityViewModels()
//        val nameObserver = Observer<String>{cadena ->
//            vista.findViewById<TextView>(R.id.texto).text=cadena}
//        model.getItem().observe(requireActivity(), nameObserver)


        return vista
    }
}