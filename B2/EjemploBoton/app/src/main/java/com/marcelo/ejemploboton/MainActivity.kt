package com.marcelo.ejemploboton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.marcelo.ejemploboton.databinding.ActivityMainBinding
import java.util.zip.Inflater

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

            bindig.boton0 -> sacarDialogo()
            bindig.materialButtonIcon -> sacarProgressIndicator()
            bindig.buttonUnelevate -> Toast.makeText(applicationContext,"BotonUnelevate",Toast
                .LENGTH_SHORT).show()
        }
    }
    fun miPulsacion(v:View){

        Toast.makeText(applicationContext,"ajsfhjkafghalkfslkjqas",Toast
            .LENGTH_SHORT).show()

    }
    fun sacarDialogo(){

        var vista =layoutInflater.inflate(R.layout.dialogo_personalizado, null)
       var dialog = MaterialAlertDialogBuilder(this)

        dialog.setView(vista)
        dialog.show()
        vista.findViewById<Button>(R.id.eliminar).setOnClickListener {
            Toast.makeText(applicationContext, "Text", Toast.LENGTH_SHORT)
        }
    }
    fun sacarProgressIndicator(){

        var pI = LinearProgressIndicator(this)
        pI.show()

    }
}