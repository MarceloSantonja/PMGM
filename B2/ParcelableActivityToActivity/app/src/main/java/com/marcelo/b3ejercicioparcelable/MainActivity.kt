package com.marcelo.b3ejercicioparcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mandarBoton = findViewById<Button>(R.id.MandarButton)
        var dni = findViewById<EditText>(R.id.DNIEditText)
        var nombre = findViewById<EditText>(R.id.NombreEditText)
        var edad = findViewById<EditText>(R.id.EdadEditText)

        mandarBoton.setOnClickListener {
        val pers = Persona(dni.text.toString(),nombre.text.toString(),edad.text.toString().toInt())
            val intento = Intent(applicationContext,Activity2::class.java)
            intento.putExtra("PERSONA",  pers)
            startActivity(intento)
        }
    }
}