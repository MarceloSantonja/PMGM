package com.marcelo.ejemplo1fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class transferirDatos : ViewModel() {
    private val datos = MutableLiveData<String>()



    fun getItem():LiveData<String>{
    return datos

    }

    fun  setItem(item:String){
    datos.value = item

    }

}