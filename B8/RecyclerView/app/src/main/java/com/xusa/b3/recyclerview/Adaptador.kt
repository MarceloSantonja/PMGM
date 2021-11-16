package com.xusa.b3.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adaptador( datos:ArrayList<Usuario>, var contexto: Context): RecyclerView.Adapter<HolderUsuario>(),View.OnClickListener {
    lateinit var clickListener: View.OnClickListener
    lateinit var listenerUsuario: PasarUsuario
    lateinit var datos: ArrayList<Usuario>

    init {
        this.datos = datos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderUsuario {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.linea_recycler, parent, false)
        var holderUsuario = HolderUsuario(view, 0, contexto)
        holderUsuario.apellidoOnClickListener(object : PasarApellido {
            override fun pasarApellido(apellidos: String) {
                Toast.makeText(contexto, apellidos, Toast.LENGTH_SHORT).show()
            }
        })
        holderUsuario.apellidoOnLongListener(object : PasarUsuario {
            override fun pasarUsuario(usuario: Usuario) {
                listenerUsuario.pasarUsuario(usuario)
            }
        })


        /*PasarApellido {
             Toast.makeText(contexto,"ASDFADSF",Toast.LENGTH_SHORT).show()
         })*/
        view.setOnClickListener(this)
        return holderUsuario
    }

    override fun onBindViewHolder(holder: HolderUsuario, position: Int) {
        holder.bind(datos.get(position),position)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    fun PulsarItemListener(listener: View.OnClickListener) {
        clickListener = listener
    }

    override fun onClick(p0: View?) {
        clickListener.onClick(p0)
    }

    fun onLongClickUsuari(lister: PasarUsuario) {
        listenerUsuario = lister
    }
}
