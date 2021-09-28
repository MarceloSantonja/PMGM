package com.marcelob2.b3ejercicioparcelable1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.marcelob2.personallibrary.Persona

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mandarBoton = findViewById<Button>(R.id.MandarButton)
        var dni = findViewById<EditText>(R.id.DNIEditText)
        var nombre = findViewById<EditText>(R.id.NombreEditText)
        var edad = findViewById<EditText>(R.id.EdadEditText)
//unir modulo con otro


        //vas por
        mandarBoton.setOnClickListener {
            //val pers = Persona(dni.text.toString(),nombre.text.toString(),edad.text.toString().toInt())

        }
    }
}