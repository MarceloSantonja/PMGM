package com.ejemplos.b10.ejemploserviciov1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    var intentoPrimerPlano:Intent?=null
    var intentoSegundoPlano:Intent?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<MaterialButton>(R.id.primerPlano).setOnClickListener{
            intentoPrimerPlano=Intent(applicationContext,MyService::class.java)
            intentoPrimerPlano?.putExtra("CADENA","Dato Pasado desde Main")
            startService(intentoPrimerPlano)
        }
        findViewById<MaterialButton>(R.id.segundoPlano).setOnClickListener{
            intentoSegundoPlano=Intent(applicationContext,MyServiceSegundoPlano::class.java)
            intentoSegundoPlano?.putExtra("CADENA","Dato Pasado desde Main")
            startService(intentoSegundoPlano)
        }
    }
    override fun onDestroy() {
        super.onDestroy()

        if(intentoPrimerPlano!=null) stopService(intentoPrimerPlano)
        if(intentoSegundoPlano!=null)stopService(intentoSegundoPlano)
    }
}