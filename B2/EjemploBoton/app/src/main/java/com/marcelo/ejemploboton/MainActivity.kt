package com.marcelo.ejemploboton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcelo.ejemploboton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindig:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)
        bindig.texto.text = "Soy el texto cambiado con el Binding"
    }
}