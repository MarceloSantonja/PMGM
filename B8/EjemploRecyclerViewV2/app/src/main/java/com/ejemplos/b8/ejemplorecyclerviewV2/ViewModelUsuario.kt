package com.ejemplos.b8.ejemplorecyclerviewV2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelUsuario: ViewModel() {
    var listaUsuarios:MutableLiveData<ArrayList<Usuario>>

    init{
        listaUsuarios=MutableLiveData<ArrayList<Usuario>>()
        setListaUsuarios(anadirDatos())
    }
    fun setListaUsuarios(lista:ArrayList<Usuario>)
    {
        listaUsuarios.value=lista
    }
    fun getLiveDataUsuarios()=listaUsuarios
    fun getUsuarios():ArrayList<Usuario> =listaUsuarios.value!!
    fun addUsuario(usuario:Usuario){
        listaUsuarios.value?.add(usuario)
    }
    private fun anadirDatos():ArrayList<Usuario> {
        var datos = ArrayList<Usuario>()
        for (i in 0..19)
            datos.add(Usuario("nombre$i", "apellido1$i   Apellido2$i"))
        return datos
    }
}