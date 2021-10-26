package com.marcelo.ejemplo1fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var pulsado = false
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.boton).setOnClickListener {

            val fragmentTransation = supportFragmentManager.beginTransaction()
            if (!pulsado) {
                fragmentTransation.add(R.id.contenedorFragment2, Fragment2())

            } else {
                fragmentTransation.add(R.id.contenedorFragment2, Fragment1())

        }
            fragmentTransation.commit()
            pulsado = !pulsado
            fragmentTransation.addToBackStack(null)
        }
    }
}