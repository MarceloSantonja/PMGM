package com.ejemplos.b10.ejemploworkmanagerpasandodatos


import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


class WorkManagerComprobarAcceso(var context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    
    override fun doWork(): Result {
        val bcIntent = Intent()
        bcIntent.action=MainActivity.ACCESODENEGADO
        val user = inputData.getString("USER")
        val pass = inputData.getString("PASS")
        //Simulamos búsqueda en una BD en la nube, que compruebe user/pass
        for (i in 0..10) {
            Thread.sleep(1000)
            Log.d("DATOS", i.toString())
        }
        if(user=="rosa" && pass=="roja") bcIntent.action = MainActivity.ACCESOPERMITIDO
        bcIntent.putExtra("USER",user)
        applicationContext.sendBroadcast(bcIntent)
        return Result.success()
    }
}