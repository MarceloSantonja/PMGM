package com.marcelo.intentimplicitoalmacenamientodeinformacin

import android.Manifest
import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar
import com.marcelo.intentimplicitoalmacenamientodeinformacin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val resultadoCamara :
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
    fun tomarFoto() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultadoCamara.launch(cameraIntent)
    }

    fun tomarGaleria() {
        val cameraIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        resultadoGaleria.launch(cameraIntent)
    }

    fun creaContratos() {
        resultadoCamara =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.imagen.setImageBitmap(result.data?.extras?.get("data") as Bitmap)

                }
            }
        resultadoGaleria =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.imagen.setImageURI(result.data?.data)
                }
            }
    }

}