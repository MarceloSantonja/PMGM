package com.juandi.b3.parcelables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.texto).setOnClickListener {
            val intento = Intent(applicationContext, Activity2::class.java)
            intento.putExtra("DATOS", (Persona("Pepe", 23)))
            startActivity(intento)

        }

    }
}