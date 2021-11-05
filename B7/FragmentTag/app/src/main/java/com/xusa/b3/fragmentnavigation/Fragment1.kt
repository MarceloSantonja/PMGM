package com.xusa.b3.fragmentnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class Fragment1 :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      // var bunde: Bundle?=arguments
        super.onCreateView(inflater, container, savedInstanceState)
        val vista=inflater.inflate(R.layout.fragment1,container,false)


        vista.findViewById<TextView>(R.id.texto).setOnClickListener {
            var bundle=Bundle()
            bundle.putString("DATO", "Hola Mundo")
            val navControler= NavHostFragment.findNavController(this)
            navControler.navigate(R.id.action_fragment1_to_fragment2,bundle)
        }

        return vista
    }

}