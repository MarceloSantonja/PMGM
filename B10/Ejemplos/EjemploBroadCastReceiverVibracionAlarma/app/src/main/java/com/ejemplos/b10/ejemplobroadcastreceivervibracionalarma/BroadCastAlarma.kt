package com.ejemplos.b10.ejemplobroadcastreceivervibracionalarma

import android.os.Vibrator
import android.widget.Toast
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import androidx.annotation.RequiresApi

class BroadCastAlarma : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent?) {
        Toast.makeText(
            context,
            "Vibración activa porque el tiempo se ha terminado",
            Toast.LENGTH_LONG
        ).show()
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(VibrationEffect.createOneShot(8000, VibrationEffect.DEFAULT_AMPLITUDE))
    }
}
