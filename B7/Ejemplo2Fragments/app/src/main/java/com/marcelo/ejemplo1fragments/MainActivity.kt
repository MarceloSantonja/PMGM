package com.marcelo.ejemplo1fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var pulsado = false
        setContentView(R.layout.activity_main)
        var fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.contenedor, Fragment1())
        fragmentTransition.commit()
          val model:transferirDatos by viewModels()

        val nameObserver = Observer<String> { cadena ->
            var fragmentTransition = supportFragmentManager.beginTransaction()

            var fragment2 = Fragment2()
            var bundle =  Bundle()
            bundle.putString("DATO",model.getItem().value)
            fragment2.arguments=bundle




            fragmentTransition.add(R.id.contenedor, fragment2)
            fragmentTransition.addToBackStack("fragment2")
            fragmentTransition.commit()


        }
        model.getItem().observe(this, nameObserver)
    }
}