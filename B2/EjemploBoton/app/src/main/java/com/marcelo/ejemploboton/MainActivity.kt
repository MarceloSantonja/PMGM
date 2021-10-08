package com.marcelo.ejemploboton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.marcelo.ejemploboton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var bindig:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        bindig.boton.setOnClickListener{
            Toast.makeText(applicationContext,"Boton",Toast.LENGTH_SHORT).show()
        }
        bindig.toogglegroup.addOnButtonCheckedListener { group, checkedId, isChecked ->  }
        bindig.boton0.setOnClickListener(this)
        bindig.materialButtonIcon.setOnClickListener(this)
        bindig.buttonUnelevate.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){

            bindig.boton0 -> Toast.makeText(applicationContext,"Boton0",Toast.LENGTH_SHORT).show()
            bindig.materialButtonIcon -> Toast.makeText(applicationContext,"BotonIco",Toast
                .LENGTH_SHORT).show()
            bindig.buttonUnelevate -> Toast.makeText(applicationContext,"BotonUnelevate",Toast
                .LENGTH_SHORT).show()
        }
    }
    fun miPulsacion(v:View){

        Toast.makeText(applicationContext,"ajsfhjkafghalkfslkjqas",Toast
            .LENGTH_SHORT).show()

    }
}