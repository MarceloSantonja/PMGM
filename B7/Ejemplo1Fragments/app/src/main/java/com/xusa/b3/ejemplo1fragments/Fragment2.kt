package com.xusa.b3.ejemplo1fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer


class Fragment2:Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val model:TransferirDatos by activityViewModels()
        super.onCreateView(inflater, container, savedInstanceState)
        val vista=inflater.inflate(R.layout.fragment2,container,false)

        val nameObserver = Observer<String>{datoCadena ->
            vista.findViewById<TextView>(R.id.texto).text=datoCadena}

        model.getItem().observe(requireActivity(), nameObserver)


        return vista
    }
}