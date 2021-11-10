package com.marcelo.ejerciciopropuestodialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    // 3 fragments 2 normales y uno que deriva de fragmentdialog
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val framentManager=supportFragmentManager
        val fragmentTransaction=framentManager.beginTransaction()
        val dialogFragmento= DialogFragment()
        fragmentTransaction.add(R.id.fragment_container,dialogFragmento)
        fragmentTransaction.commit()

        val botonCrear =findViewById<Button>(R.id.crear_boton)
        val botonEntrar =findViewById<Button>(R.id.entrar_boton)


        botonEntrar.setOnClickListener {
            val FT= getSupportFragmentManager().beginTransaction()
            FT.replace(R.id.fragment_container,FragmentEntrar())
            FT.addToBackStack(null)
            FT.commit()
        }


    }
}