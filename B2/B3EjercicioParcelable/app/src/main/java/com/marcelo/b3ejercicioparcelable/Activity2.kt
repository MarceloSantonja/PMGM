package com.marcelo.b3ejercicioparcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val persona = intent.getParcelableExtra<Persona>("Persona")
        val dni = findViewById<TextView>(R.id.DNITextView)
        val edad = findViewById<TextView>(R.id.EdadTextView)
        val nombre = findViewById<TextView>(R.id.NombreTextView)

        findViewById<Button>(R.id.VerDatosButton).setOnClickListener {

            Toast.makeText(applicationContext, persona?.dni ,Toast.LENGTH_SHORT).show()
            // el Toast me peta la aplicación

            if (persona !=null){

                dni.text = persona.dni
                nombre.text = persona.nombre
                edad.text = persona.edad.toString()
            }

        }




    }
}