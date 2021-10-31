package com.marcelo.agenda

import android.Manifest
import android.Manifest.permission.CAMERA
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Camera
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import com.marcelo.agenda.databinding.LayoutAddNewContactBinding

@RequiresApi(Build.VERSION_CODES.Q)
class MainActivity : AppCompatActivity() {

    /*cuando pulsamos a la imagen asociada al contacto nos permitirá abrir la cámara y hacer una foto.
     */

    private lateinit var binding: LayoutAddNewContactBinding
    private lateinit var resultadoCamara: ActivityResultLauncher<Intent>
    private lateinit var resultadoGaleria: ActivityResultLauncher<Intent>

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_add_new_contact)
        binding = LayoutAddNewContactBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        creaContratos()

        binding.contactoImage.setOnClickListener {

               solicitarPermisoCamara()
            //tomarGaleria()
        }

    }

    val RESPUESTA_PERMISOS = 111

    @RequiresApi(Build.VERSION_CODES.Q)
    fun solicitarPermisoCamara() {
        if (checkSelfPermission(CAMERA) == PackageManager.PERMISSION_DENIED) {
            if (shouldShowRequestPermissionRationale(CAMERA)) {
            }
            requestPermissions(arrayOf(CAMERA), RESPUESTA_PERMISOS)
        } else tomarFoto()
    }


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onRequestPermissionsResult(
        requestCode: Int,//código de identificación del resultado
        permissions: Array<out String>,//array con los nombres de los permisos
        grantResults: IntArray//array de 0 y -1 (permitido, no permitido) en orden
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            RESPUESTA_PERMISOS -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        tomarFoto()

            }
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

    @RequiresApi(Build.VERSION_CODES.Q)
    fun creaContratos() {
        resultadoCamara =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.contactoImage.setImageBitmap(result.data?.extras?.get("data") as Bitmap)

                }
            }
        resultadoGaleria =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.contactoImage.setImageURI(result.data?.data)
                }
            }
    }
}
