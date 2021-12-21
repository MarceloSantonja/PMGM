package com.ejemplos.b10.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.IntentFilter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //A partir de las últimas versiones de android, no se permite iniciar
        //un receiver sin actividad de lanzamiento, por lo que lanzamos la
        //actividad y la finalizamos el broadcast quedará en segundo plano
        //hasta que se desinstala la actividad
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED )
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED )
        val rcv = MiBroadcastReceiver()
        registerReceiver(rcv, filter)
        finish()
    }
}