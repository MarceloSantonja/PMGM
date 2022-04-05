package com.marcelo.pruebas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.marcelo.pruebas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button = binding.materialButtonFlat

        button.setOnClickListener{
            val editText = binding.EditTextHello
            val message = editText.text.toString()
            val intent = Intent(this, FragmentUno::class.java).apply {
                putExtra("mensaje", message)
            }
            try {
                startActivity(intent)
            } catch (e: Exception) {
                val duracion :Int = 5
                Toast.makeText(this, e.localizedMessage,Toast.LENGTH_LONG).show()
                println(e.localizedMessage)
            }

        }

    }
}