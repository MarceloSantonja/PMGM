package com.xusa.b3.ejemplo1fragments


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() , PasaDatos{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragmentTransation=supportFragmentManager.beginTransaction()
        fragmentTransation.add(R.id.contenedor,Fragment1())
        fragmentTransation.commit()
    }

    fun abreFragement(cadena:String)
    {
        var fragmentTransation=supportFragmentManager.beginTransaction()

        var fragment2=Fragment2()
        var bundle=Bundle()
        bundle.putString("DATO",cadena)
        fragment2.arguments=bundle
        fragmentTransation.replace(R.id.contenedor,fragment2)
        fragmentTransation.addToBackStack("fragment2")
        fragmentTransation.commit()
    }
    override fun datosCadena(cadena: String) {
        abreFragement(cadena)
    }
}