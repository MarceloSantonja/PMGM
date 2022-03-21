package com.marcelo.t5intentimplicito

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.marcelo.t5intentimplicito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vistaImagen = binding.fotoImageView
        val vistacorreo = binding.EmailButton
        val botonLlamar = binding.LLamarButton

        vistaImagen.setOnClickListener{view:View->

        }



    }
}