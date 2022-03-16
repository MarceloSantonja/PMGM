package com.marcelo.pruebas1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val color = resources.getColor(android.R.color.holo_blue_bright,theme)
        val cadena = "El resultado de:"
        val a = 2
        val b = 5
        println("$cadena $a + $b es: ${a + b}")


    }
}