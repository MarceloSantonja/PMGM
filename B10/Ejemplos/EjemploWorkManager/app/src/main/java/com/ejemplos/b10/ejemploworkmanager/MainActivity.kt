package com.ejemplos.b10.ejemploworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import java.util.*

import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Repite el servicio cada 15 segundos y lo ponen en la cola para que sea resuelto cuando se
        //pueda
        val workPeriodico =PeriodicWorkRequestBuilder<WorkPeriodico>(16, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workPeriodico)
        val workManager=WorkManager.getInstance(this)
    }
}