package com.marcelo.intentimplicitoalmacenamientodeinformacin

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar
import com.marcelo.intentimplicitoalmacenamientodeinformacin.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val telefonoButton = binding.telefonoImageButton
        val imagenButton = binding.imageView
        val emailButton = binding.mailImageButton
        val REQUEST_PHONE_CALL = 1

        telefonoButton.setOnClickListener (View.OnClickListener {
            if(binding.telefonoEditText.text.toString()!=null){

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission))


                empezarLLamada(binding.telefonoEditText.text.toString())

            }else{

                Toast.makeText(this,"falla mucho",Toast.LENGTH_SHORT).show()

            }
        })


    }
    fun empezarLLamada(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}