package com.marcelo.resuelto2activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener{
            val intento = Intent(applicationContext, Activity2::class.java)
            intento.putExtra("DATO",findViewById<EditText>(R.id.datos).text.toString())
            startActivity(intento)
        }




    }
}