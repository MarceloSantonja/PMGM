package com.ejemplos.b10.ejemploserviciov2

import android.app.Service
import android.content.Intent
import android.os.Binder

import android.os.IBinder
import java.util.*
import kotlin.collections.ArrayList


class MiService : Service() {
    var timer: Timer?=null
    var miBinder: IBinder = MiBinder()
    lateinit var lista: ArrayList<String>
    var array = arrayOf("blanco", "azul", "verde")
    var pos = 0
    override  fun onCreate() {
        pos = 0
        super.onCreate()
        timer=Timer()
        lista = ArrayList()
        pollForUpdates()
    }
    fun pollForUpdates() {
        timer?.scheduleAtFixedRate(object : TimerTask() {
            override  fun run() {
                if (lista.size >= array.size) {
                    lista.removeAt(0)
                }
                lista.add(array[pos])
                pos++
                if (pos >= array.size) pos = 0
            }
        }, 0, UPDATE_INTERVAL)
    }
    override  fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
    override fun onBind(intent: Intent?): IBinder {
        return miBinder
    }
    fun getLista(): List<String> {
        return lista
    }
    internal inner class MiBinder : Binder() {
        val service: MiService
            get() = this@MiService
    }
    companion object {
        private const val UPDATE_INTERVAL: Long = 5000
    }
}
