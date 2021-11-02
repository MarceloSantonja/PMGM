package com.xusa.b3.ejemplo1fragments


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         var pulsado=false
        setContentView(R.layout.activity_main)
        var fragmentTransation=supportFragmentManager.beginTransaction()
        fragmentTransation.add(R.id.contenedor,Fragment1())
        fragmentTransation.commit()
       // fragmentTransation.addToBackStack("fragment1")
         val model:TransferirDatos by viewModels()

        val nameObserver = Observer<String>{datoCadena ->
            var fragmentTransation=supportFragmentManager.beginTransaction()

            var fragment2=Fragment2()
            var bundle=Bundle()
            bundle.putString("DATO",model.getItem().value)
            fragment2.arguments=bundle
            fragmentTransation.add(R.id.contenedor,fragment2)
            fragmentTransation.addToBackStack("fragment2")
            fragmentTransation.commit()
        }

        model.getItem().observe(this, nameObserver)
    }
}