package com.ejemplos.b10.ejemploworkmanagerpasandodatos

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.work.*
import java.lang.RuntimeException

//App que mediante un WorkManager al que le llegan unos datos user/pass realiza una tarea larga en
//segundo plano (simulando que consulta el acceso permitido). Cuando termina abre un Fragment
//con el nombre del usuario devuelto mediante un intent y broadcastReceiver
//Para permitir acceso user=rosa pass=roja

class MainActivity : AppCompatActivity() {
    lateinit var dialogo: AlertDialog
    lateinit var progresBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progresBar = findViewById(R.id.progressBar)

        if (intent.getStringExtra("ACCESO") == ACCESOPERMITIDO) {
            //si se abre la aplicación desde el broadcast pero después de haberla cerrado
            //y con el acceso comprobado
            val fT = supportFragmentManager.beginTransaction();
            fT.add(R.id.contenedor, Fragment2(intent.getStringExtra("USER")!!))
            fT.addToBackStack(null)
            fT.commit()
        }
        else {
            dialogo = createLoginDialogo().create()
            dialogo.show()
            val filter = IntentFilter()
            filter.addAction(ACCESOPERMITIDO)
            filter.addAction(ACCESODENEGADO)
            val rcv = ComprobarAccesoReceiver()
            registerReceiver(rcv, filter)
        }
    }

    fun createLoginDialogo(): MaterialAlertDialogBuilder {
        val builder = MaterialAlertDialogBuilder(this@MainActivity)
        val inflater = this@MainActivity.layoutInflater
        val v = inflater.inflate(R.layout.dialogo, null)
        builder.setView(v)
        val crear = v.findViewById<View>(R.id.crear_boton) as Button
        crear.setOnClickListener {

            dialogo.dismiss()
            val user = v.findViewById<TextInputEditText>(R.id.nombre_input).text.toString()
            val pass = v.findViewById<TextInputEditText>(R.id.contra_input).text.toString()

            var workManager=WorkManager.getInstance(MainActivity@ this)
            val work = OneTimeWorkRequestBuilder<WorkManagerComprobarAcceso>()
            //Datos para añadir al trabajo
            val inputData = Data.Builder()
                .putString("USER", user)
                .putString("PASS", pass)
                .build()
            work.setInputData(inputData)
            //Si se pone la restricción de estar conectado por ejemplo, y se quitan los datos y wiffi del
            //dispositivo, la tarea se parará y volverá a reanudarse cuando conectemos de nuevo
            val restriccion = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            work.setConstraints(restriccion)
            val peticionTrabajo=work.build()
            //Inicia una sola vez el servicio ´OneTimeWorkRequestBuilder´ y lo pone en la cola para que sea
            //resuelto
            workManager.enqueue(peticionTrabajo)
            //workManager.cancelWorkById(peticionTrabajo.id)
            progresBar.visibility = View.VISIBLE
        }
        return builder
    }

    inner class ComprobarAccesoReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            progresBar.visibility = View.INVISIBLE
            if (intent.action == ACCESOPERMITIDO) {
                try {
                    val fT = supportFragmentManager.beginTransaction();
                    fT.add(R.id.contenedor, Fragment2(intent.getStringExtra("USER")!!))
                    fT.addToBackStack(null)
                    fT.commit()
                } catch (e: RuntimeException) {
                    //trampa para esquivar la excepción creada al intentar abrir un Fragment
                    //cuando se ha cerrado la aplicación siempre que se use una version android
                    //menor a 10. A partir de la 10, no se permite que los servicios en segundo
                    // plano inicien app. Se debe hacer preguntando con una notificación alta prioridad
                    // pantalla completa
                    var intento = Intent()
                    intento.setComponent(
                        ComponentName(
                            "com.ejemplos.b10.ejemploworkmanagerpasandodatos",
                            "com.ejemplos.b10.ejemploworkmanagerpasandodatos.MainActivity"
                        )
                    )
                    //Se añade el Flag para que se pueda abrir una activity desde un servicio
                    intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    intento.putExtra("ACCESO", ACCESOPERMITIDO)
                    intento.putExtra("USER",intent.getStringExtra("USER"))
                    if (intento.resolveActivity(context!!.packageManager) != null) ContextCompat.startActivity(
                        context,
                        intento,
                        null
                    )
                }
            } else Toast.makeText(
                applicationContext, "ACCESO DENEGADO DATOS INCORRECTOS!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        val ACCESOPERMITIDO = "ACCESO PERMITIDO"
        val ACCESODENEGADO = "ACCESO DENEGADO"
    }
}