package com.marcelo.a3actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)


        val texto = intent.getStringExtra("DATO")
        Toast.makeText(
            applicationContext,
            texto,
            Toast.LENGTH_SHORT
        ).show()

        findViewById<TextView>(R.id.Activity2TextView).setOnClickListener {
            val intento = Intent()
            intento.putExtra("DATORETURN","Actividad 2")
            setResult(RESULT_OK,intento)
            finish()

        }


    }
}