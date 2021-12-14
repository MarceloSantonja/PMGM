package com.ejemplos.b10.ejemplocorrutinas1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.button.MaterialButton

class  FragmentUno: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_uno,container,false)
        view.findViewById<Button>(R.id.cargaFragment).setOnClickListener { aceptar() }
        return view
    }
    fun aceptar()
    {
        val navController= NavHostFragment.findNavController(this)
        if (navController.currentDestination?.id == R.id.fragmentUno)
            navController.navigate(R.id.action_fragmentUno_to_fragmentDos)
    }
}