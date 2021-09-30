package com.marcelo.resuelto2activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val textView = findViewById<TextView>(R.id.textoActivity2)
        val intento = this.intent
        textView.setText("Hola "+ intento.getStringExtra("DATO") + " ¿como estas?")
    }
}