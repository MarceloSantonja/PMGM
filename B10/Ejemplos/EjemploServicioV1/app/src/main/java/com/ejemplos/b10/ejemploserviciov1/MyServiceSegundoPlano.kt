package com.ejemplos.b10.ejemploserviciov1

import android.app.SearchManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyServiceSegundoPlano: Service() {
     var hilo=Thread()
    override fun onStartCommand
                (intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        val cadena=intent?.getStringExtra("CADENA")
        Log.d("DATO","Recibiendo Intent ....")
        if(hilo==null || !hilo?.isAlive) {
            hilo = Thread {
                while (true) {
                    Log.d(
                        "DATO", "Mostrando intent ...." +
                                "${cadena}"
                    )
                     Thread.sleep(10000)

                   /* Estas líneas me iniciarían una busqueda cada 10 segundos
                   //Aunque la aplicación no estuviese en primer plano
                val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                    putExtra(SearchManager.QUERY, "iesdoctorbalmis")
                }
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)}*/
                }
            }
            hilo.start()
        }

        return START_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    override fun onDestroy() {
        Log.d("DATO","Destruyendo Intent ....")
        super.onDestroy()
    }
}