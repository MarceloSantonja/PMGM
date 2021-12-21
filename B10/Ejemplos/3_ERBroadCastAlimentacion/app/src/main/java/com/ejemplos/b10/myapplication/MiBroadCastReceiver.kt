package com.ejemplos.b10.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast


class MiBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        val action = intent.action
        if (Intent.ACTION_POWER_CONNECTED == action)
            Toast.makeText(context, "Alimentación conectada" , Toast.LENGTH_LONG).show();
         else if (Intent.ACTION_POWER_DISCONNECTED == action)
            Toast.makeText(context, "Alimentación desconectada", Toast.LENGTH_LONG).show();
    }
}
