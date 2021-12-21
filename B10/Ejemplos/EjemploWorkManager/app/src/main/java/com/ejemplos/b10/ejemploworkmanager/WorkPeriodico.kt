package com.ejemplos.b10.ejemploworkmanager

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.Log.DEBUG
import androidx.core.content.ContextCompat.startActivity
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay


class WorkPeriodico(val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams){
    override fun doWork(): Result {
       for(i in 0..15) {
           Thread.sleep(1000)
           Log.d("DATOS", i.toString())
       }
        var intento=Intent()
        intento.setComponent(
            ComponentName("com.ejemplos.b10.ejemploviewmodelcorrutinas",
            "com.ejemplos.b10.ejemploviewmodelcorrutinas.MainActivity")
        )
        //Se añade el Flag para que se pueda abrir una activity
        // desde un hilo en segundo plano
        intento.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if (intento.resolveActivity(context.packageManager) != null)
            startActivity(context,intento,null)
        return Result.success()
    }
}