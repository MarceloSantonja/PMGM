package com.ejemplos.b8.ejemplorecyclerviewV2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsuarioViewModel : ViewModel() {
    private var listaDatosLiveData=MutableLiveData<ArrayList<Usuario>>()

    fun getListaDatos():ArrayList<Usuario>?{
       return  listaDatosLiveData.value
    }
    fun getLiveDataListaDatos():LiveData<ArrayList<Usuario>>{
        return  listaDatosLiveData
    }
    fun setListaDatos(datos:ArrayList<Usuario>)
    {
        listaDatosLiveData.value=datos
    }
    init{
        setListaDatos(anadirDatos())
    }
    private fun anadirDatos():ArrayList<Usuario> {
        var datos = ArrayList<Usuario>()
        for (i in 0..19)
            datos.add(Usuario("nombre$i", "apellido1$i   Apellido2$i"))
        return datos
    }
}