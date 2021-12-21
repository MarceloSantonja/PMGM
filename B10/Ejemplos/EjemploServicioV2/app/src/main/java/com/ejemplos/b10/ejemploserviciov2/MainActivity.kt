package com.ejemplos.b10.ejemploserviciov2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context.BIND_AUTO_CREATE

import android.content.Intent

import android.content.ComponentName

import android.widget.Toast

import android.os.IBinder

import android.content.ServiceConnection

import android.widget.ArrayAdapter


import android.app.Activity
import android.view.View
import android.widget.Button
import android.widget.ListView
import com.ejemplos.b10.ejemploserviciov2.MiService.MiBinder


class MainActivity : Activity() {
    var miservicio: MiService?=null
    lateinit  var values: ArrayList<String>
    lateinit  var adapter: ArrayAdapter<String>
    lateinit  var lista: ListView
    lateinit var boton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lista = findViewById(R.id.listView)
        boton = findViewById(R.id.button)
        doBindService()
        values = ArrayList()
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)
        lista.setAdapter(adapter)
        boton.setOnClickListener {  showServiceData()}
    }
    private val mConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            miservicio = (service as MiBinder).service
            Toast.makeText(this@MainActivity, "Connectado", Toast.LENGTH_LONG).show()
        }
        override fun onServiceDisconnected(name: ComponentName) {
            miservicio = null
        }
    }
    fun doBindService() {
        bindService(Intent(this, MiService::class.java), mConnection, BIND_AUTO_CREATE)
    }
    fun showServiceData() {
        if (miservicio != null) {
            val listaTrabajo: List<String> = miservicio!!.getLista()
            values.clear()
            values.addAll(listaTrabajo)
            adapter.notifyDataSetChanged()
        }
    }
}
