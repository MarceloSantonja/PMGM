package com.ejemplos.b10.a4_ergeneradornumerosworkmanager

import android.content.Context
import android.content.Intent
import androidx.work.Worker
import androidx.work.WorkerParameters

class GeneradorNumeros(var context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        val datos=inputData
        var contador= datos.getInt("INICIO",0)
        while (!isStopped) {
            var i = Intent(ACCION)
            i.putExtra("VALORCONTADOR", contador)
            applicationContext.sendBroadcast(i)
            contador++
            Thread.sleep(1000)
        }
        return Result.success()
    }
    companion object
    {
        const val ACCION = "com.ejemplos.b10.a4_ergeneradornumerosworkmanager.recibirNumero"
    }
}