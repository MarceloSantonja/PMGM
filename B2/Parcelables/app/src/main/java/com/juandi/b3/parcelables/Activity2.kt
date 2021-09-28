package com.juandi.b3.parcelables

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intento = intent
        findViewById<TextView>(R.id.texto).text=intent.getParcelableExtra<Persona>("DATOS").toString()

    }
}
