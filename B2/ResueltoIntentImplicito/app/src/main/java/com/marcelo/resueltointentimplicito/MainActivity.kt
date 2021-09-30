package com.marcelo.resueltointentimplicito

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.USE_FULL_SCREEN_INTENT
import android.app.SearchManager
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import java.io.File

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.NavegadorButton).setOnClickListener(
            //funciona mal*******
            View.OnClickListener { val intento = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, "iesdoctorbalmis")
            }
                if(intento.resolveActivity(packageManager)!=null)startActivity(intent)
            })

        findViewById<Button>(R.id.AbrirButton).setOnClickListener {
            val intent = Intent()
            intent.setComponent(ComponentName("com.marcelo.a3actividades","com.marcelo.a3actividades.MainActivity"))
            if(intent.resolveActivity(packageManager)!=null) startActivity(intent)
        }

        findViewById<Button>(R.id.EscucharButton).setOnClickListener        {

            solicitarPermisosYEscucharCancion()
        }

        }

    val RESPUESTA_PERMISOS = 111
    @RequiresApi(Build.VERSION_CODES.Q)
    fun solicitarPermisosYEscucharCancion()
    {
        if (checkSelfPermission(READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) { requestPermissions(arrayOf(READ_EXTERNAL_STORAGE), RESPUESTA_PERMISOS)
        }
        else escucharCancion()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            RESPUESTA_PERMISOS -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(
                        applicationContext,
                        permissions[0] + " Permiso concedido",
                        Toast.LENGTH_SHORT
                    ).show()
                escucharCancion()
            }
        }
    }
    private fun escucharCancion() { // funciono una vez pero despues fallo mirar el provider_path
        var directorio = getExternalFilesDir(null)?.absolutePath
        directorio = directorio?.substring(0,directorio?.indexOf("Android"))
        val data = File(directorio+ "music/minions.mp3")
        val uri = FileProvider.getUriForFile(
            this@MainActivity,
            BuildConfig.APPLICATION_ID +".provider",
            data
        )
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(uri, "audio/.mp3")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent)
    }






}