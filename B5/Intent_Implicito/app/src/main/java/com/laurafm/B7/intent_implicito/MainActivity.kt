package com.laurafm.B7.intent_implicito

import android.Manifest.permission.*
import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Message
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import com.laurafm.B7.intent_implicito.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.io.File

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    private lateinit var binding: ActivityMainBinding
    lateinit var resultadoCamara: ActivityResultLauncher<Intent>



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        solicitarPermisos()
        creaContratos()

        binding.BotonCamaraImageButton.setOnClickListener{
            tomarFoto()
        }
        binding.telefonobuton.setOnClickListener{
            llamada()
        }
        binding.emailbuton.setOnClickListener{
            composeEmail(binding.email.text.toString())
        }
    }
    fun tomarFoto() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultadoCamara.launch(cameraIntent)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun creaContratos() {
        resultadoCamara =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.BotonCamaraImageButton.setImageBitmap(result.data?.extras?.get("data") as Bitmap)

                }
            }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun llamada()
    {
        val intent: Intent =
            Intent(ACTION_CALL, Uri.parse("tel:" + binding.numeroTelefono.text.toString()))
            startActivity(intent)
    }
    fun composeEmail(subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
        else
        {
            println("El campo esta vacio");
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)

        val RESPUESTA_PERMISOS = 111

        @RequiresApi(Build.VERSION_CODES.M)
        fun solicitarPermisos() {
            if (checkSelfPermission(CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(
                    CALL_PHONE
                ) == PackageManager.PERMISSION_DENIED || checkSelfPermission(READ_VOICEMAIL) == PackageManager.PERMISSION_DENIED
            ) {
                requestPermissions(arrayOf(CAMERA, CALL_PHONE, READ_VOICEMAIL), RESPUESTA_PERMISOS)
            }
        }

        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            when {
                RESPUESTA_PERMISOS == requestCode && grantResults.isNotEmpty() -> {
                    for (i in 0..permissions.size - 1) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                            Toast.makeText(
                                applicationContext, "Permiso Concedido " +
                                        permissions[i], Toast.LENGTH_SHORT
                            ).show()
                    }
                }
            }
        }
    }
