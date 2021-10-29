package com.marcelo.intentimplicitoalmacenamientodeinformacin

import android.Manifest
import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar
import com.marcelo.intentimplicitoalmacenamientodeinformacin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var resultadoCamara: ActivityResultLauncher<Intent>
    private lateinit var resultadoGaleria: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val resultadoCamara:
        val telefonoButton = binding.telefonoImageButton
        val imagenButton = binding.imageView
        val emailButton = binding.mailImageButton
        val REQUEST_PHONE_CALL = 1



        telefonoButton.setOnClickListener(View.OnClickListener {
            if (binding.telefonoEditText.text.toString() != null) {

                solicitarPermisoLlamada()



                empezarLLamada(binding.telefonoEditText.text.toString())

            } else {

                Toast.makeText(this, "falla mucho", Toast.LENGTH_SHORT).show()

            }
        })


    }

    fun empezarLLamada(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:$phoneNumber")

        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


    val RESPUESTA_PERMISOLLAMADA = 111

    @RequiresApi(Build.VERSION_CODES.Q)
    fun solicitarPermisoLlamada() {
        if (checkSelfPermission(ACTION_CALL) == PackageManager.PERMISSION_DENIED) {
            if (shouldShowRequestPermissionRationale(ACTION_CALL))
                Toast.makeText(this, "Se necesitan permisos de llamada", Toast.LENGTH_SHORT).show()
            requestPermissions(arrayOf(ACTION_CALL), RESPUESTA_PERMISOLLAMADA)
        } else empezarLLamada(binding.telefonoEditText.text.toString())
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,//código de identificación del resultado
        permissions: Array<out String>,//array con los nombres de los permisos
        grantResults: IntArray//array de 0 y -1 (permitido, no permitido) en orden)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            RESPUESTA_PERMISOLLAMADA -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(
                        applicationContext,
                        permissions[0] + " Permiso concedido",
                        Toast.LENGTH_SHORT
                    ).show()
                if (grantResults[1] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(
                        applicationContext,
                        permissions[1] + " Permiso concedido",
                        Toast.LENGTH_SHORT
                    ).show()
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
                    binding.fotoImageView.setImageBitmap(result.data?.extras?.get("data") as Bitmap)

                }
            }
        resultadoGaleria =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.fotoImageView.setImageURI(result.data?.data)
                }
            }
    }


//    val RESPUESTA_PERMISOS = 111
//
//    @RequiresApi(Build.VERSION_CODES.Q)
//    fun solicitarPermisoOtro() {
//        if (checkSelfPermission(ACTION_CALL) == PackageManager.PERMISSION_DENIED
//            || checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_DENIED
//        ) {
//            if (shouldShowRequestPermissionRationale(ACTION_CALL))
////Si se decide explicar los motivos de los permisos con similar a un dialogo
//                if (shouldShowRequestPermissionRationale(READ_CONTACTS))
////Si se decide explicar los motivos de los permisos con similar a un dialogo
////Con requestPermissions se pide al usuario que permita los permisos,
////en este caso dos
//                    requestPermissions(arrayOf(ACTION_CALL, _CONTACTS), RESPUESTA_PERMISOS)
//        } else lanzarFuncionalidadQueRequierePermisos()
//    }



    }

}