package com.ejemplos.b10.a4_ergeneradornumerosworkmanager

import android.content.BroadcastReceiver
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.TextView
import android.widget.Toast

import android.content.Intent

import android.content.IntentFilter
import androidx.work.*
import androidx.work.OneTimeWorkRequest
import com.ejemplos.b10.a6_ergeneradornumerosworkmanager.R
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var mreceiver: MyReceiver
    lateinit var t1: TextView
    lateinit var t2: TextView
    lateinit var idWork:UUID
    var iniciado=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        t1 = findViewById(R.id.textView1)
        t2 = findViewById<TextView>(R.id.textView2)
        mreceiver = MyReceiver(t1, t2)
        val b1 = findViewById<Button>(R.id.button1)
        val b2 = findViewById<Button>(R.id.button2)
        b1.setOnClickListener { iniciarServicio() }
        b2.setOnClickListener { pararServicio() }
    }

    fun iniciarServicio() {
        if(!iniciado)
        {
            iniciado=true
            val filter =
                IntentFilter(GeneradorNumeros.ACCION)
            this.registerReceiver(mreceiver, filter)
            val datos=Data.Builder()
            datos.putInt("INICIO",t1.text.toString().toInt())
            val workManager = WorkManager.getInstance(MainActivity@ this)
            val work = OneTimeWorkRequest.Builder(GeneradorNumeros::class.java)
                .setInputData(datos.build())
                .build()
            idWork=work.id
            workManager.enqueue(work)

        }
        else  Toast.makeText(this, "El trabajo ya se ha lanzado", Toast.LENGTH_LONG).show()
    }

    fun pararServicio() {
             if (iniciado) {
                    iniciado=false
                    WorkManager.getInstance(MainActivity@ this).cancelWorkById(idWork)
                    unregisterReceiver(mreceiver)
                    Toast.makeText(this, "Trabajo detenido", Toast.LENGTH_LONG).show()
               } else Toast.makeText(this, "El Trabajo ya estaba detenido", Toast.LENGTH_LONG)
                   .show()
    }

    class MyReceiver(private val t1: TextView, private val t2: TextView) : BroadcastReceiver() {
        fun esPrimo(n: Int): Boolean {
            var i: Int
            i = 2
            while (i < n) {
                if (n % i == 0) return false
                i++
            }
            return true
        }
        override fun onReceive(context: Context?, intent: Intent) {
            val s = intent.extras!!["VALORCONTADOR"].toString()
            t1.text = s
            if (esPrimo(s.toInt())) t2.text = s
        }
        init {
            t1.text = "0"
            t2.text = "0"
        }
    }
}