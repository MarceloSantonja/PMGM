package com.ejemplos.b10.ejemploserviciov1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    override fun onCreate() {
        super.onCreate()
        Log.d("DATO","Creando servicio....")
    }
    override fun onStartCommand
                (intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.d("DATO","Recibiendo Intent ....")
        while(true)  Log.d("DATO","Mostrando intent ....+" +
                           "${intent?.getStringExtra("CADENA")}")
        return START_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? {
        Log.d("DATO","Enlazando Intent ....")
        return null
    }
    override fun onDestroy() {
        Log.d("DATO","Destruyendo Intent ....")
        super.onDestroy()
    }
}