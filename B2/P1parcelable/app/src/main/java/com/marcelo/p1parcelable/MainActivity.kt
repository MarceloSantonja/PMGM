package com.marcelo.p1parcelable

import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.MandarButton).setOnClickListener {

            var dni = findViewById<EditText>(R.id.DNIEditText)
            var nombre = findViewById<EditText>(R.id.NombreEditText)
            var edad = findViewById<EditText>(R.id.EdadEditText)
            val pers = com.marcelob2.personalibrary.Persona(
                dni.text.toString(),
                nombre.text.toString(),
                edad.text.toString().toInt()
            )
            val intento = Intent()
            intento.putExtra("PERSONA", pers)
            intento.setComponent(ComponentName("com.marcelo.p2parcelable",
                "com.marcelo.p2parcelable.MainActivity"))
            if(intento.resolveActivity(packageManager)!=null)
            startActivity(intento)
        }

    }
}