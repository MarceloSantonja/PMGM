package com.marcelo.carritocompra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcelo.carritocompra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.AddButton.setOnClickListener {

            var texto:String = binding.ContadorTexto.text.toString()
            binding.ContadorTexto.setText((texto.toInt() + 1 ).toString())

        }

    }
}