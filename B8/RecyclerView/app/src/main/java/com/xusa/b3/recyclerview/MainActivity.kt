package com.xusa.b3.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var datos=anadirDatos()
        var recyclerView=findViewById<RecyclerView>(R.id.recycler)
        var adaptador=Adaptador(datos,this)
        recyclerView.adapter=adaptador
       /* recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)*/
        adaptador.PulsarItemListener(View.OnClickListener {
            val posicion=recyclerView.getChildAdapterPosition(it)
            Toast.makeText(this,datos.get(posicion).nombre,Toast.LENGTH_LONG).show()
        })
        recyclerView.layoutManager =
           GridLayoutManager(this,4)

    }
    private fun anadirDatos():ArrayList<Usuario>
    {
        var datos = ArrayList<Usuario>()
        for (i in 0..190)
            datos.add(Usuario("nombre$i", "apellido1$i Apellido2$i"))
        return datos
    }

}