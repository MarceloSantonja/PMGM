package com.xusa.b3.fragmentnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

class Fragment3 :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    //    var bunde: Bundle?=arguments
        super.onCreateView(inflater, container, savedInstanceState)
        val vista=inflater.inflate(R.layout.fragment3,container,false)
      //  vista.findViewById<TextView>(R.id.texto).text= bunde?.getString("DATO")
        vista.findViewById<TextView>(R.id.texto).setOnClickListener {
            val navControler= NavHostFragment.findNavController(this)
            navControler.navigate(R.id.action_global_fragment2)
        }
        return vista
    }

}