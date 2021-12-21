package com.ejemplos.b10.ejemplobroadcastreceivervibracionalarma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast

import android.app.AlarmManager

import android.content.Context.ALARM_SERVICE

import androidx.core.content.ContextCompat.getSystemService

import android.app.PendingIntent

import android.content.Intent

import android.widget.EditText

import android.app.Activity
import android.view.View
import android.widget.Button


class MainActivity :AppCompatActivity() {
    lateinit var texto:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto=findViewById<EditText>(R.id.editText)
        texto.setText("0")
        findViewById<Button>(R.id.button).setOnClickListener { activar()}
    }

    private fun activar() {
        val tiempo = texto.text.toString().toInt()
        val intent = Intent(this,BroadCastAlarma::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, REQUESTCODE, intent, 0)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + tiempo * 1000,pendingIntent)
       /* alarmManager[AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + tiempo * 1000] =
            pendingIntent*/
        Toast.makeText(this, "Has fijado la alarma en " + tiempo + "segundos", Toast.LENGTH_LONG)
            .show()
    }
    companion object{
        val REQUESTCODE=1111
    }
}