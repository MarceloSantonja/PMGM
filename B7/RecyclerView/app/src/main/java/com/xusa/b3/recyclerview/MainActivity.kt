package com.xusa.b3.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var datos=anadirDatos()
        var recyclerView=findViewById<RecyclerView>(R.id.recycler)
        recyclerView.adapter=Adaptador(datos,this)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
    private fun anadirDatos():ArrayList<Usuario>
    {
        var datos = ArrayList<Usuario>()
        for (i in 0..190)
            datos.add(Usuario("nombre$i", "apellido1$i Apellido2$i"))
        return datos
    }

}