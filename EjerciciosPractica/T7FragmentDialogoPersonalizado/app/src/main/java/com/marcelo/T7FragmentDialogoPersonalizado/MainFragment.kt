package com.marcelo.T7FragmentDialogoPersonalizado

import T7FragmentDialogoPersonalizado.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton


class MainFragment : DialogFragment() {


    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
       // navController = findNavController()
        val botonEntrar = view.findViewById<MaterialButton>(R.id.entrar_boton)


        botonEntrar.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_fragmentEntrandoSistema)
        )
        val botonCrear = view.findViewById<MaterialButton>(R.id.crear_boton)

        botonCrear.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.fragmentPersona, null)
        )


        return view
    }


}