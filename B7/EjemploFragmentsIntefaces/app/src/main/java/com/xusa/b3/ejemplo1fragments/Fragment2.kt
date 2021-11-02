package com.xusa.b3.ejemplo1fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer


class Fragment2:Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var bunde:Bundle?=arguments
        super.onCreateView(inflater, container, savedInstanceState)
        val vista=inflater.inflate(R.layout.fragment2,container,false)
        vista.findViewById<TextView>(R.id.texto).text= bunde?.getString("DATO")

        //  val model:TransferirDatos by activityViewModels()

        /*    val nameObserver = Observer<String>{datoCadena ->
            vista.findViewById<TextView>(R.id.texto).text=datoCadena}

        model.getItem().observe(requireActivity(), nameObserver)*/


        return vista
    }


}