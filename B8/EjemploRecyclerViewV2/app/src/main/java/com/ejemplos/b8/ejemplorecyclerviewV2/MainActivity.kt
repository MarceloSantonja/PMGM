package com.ejemplos.b8.ejemplorecyclerviewV2

import android.os.Bundle
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    val model:ViewModelUsuario by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

companion object
{
    public fun anadirDatos():ArrayList<Usuario> {
        var datos = ArrayList<Usuario>()
        for (i in 0..19)
            datos.add(Usuario("nombre$i", "apellido1$i   Apellido2$i"))
        return datos
    }
}
}