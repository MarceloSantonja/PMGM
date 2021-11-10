package com.marcelo.ejerciciopropuestodialogfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransferirDatos : ViewModel() {
    private val datos= MutableLiveData<String>()
    fun getItem(): LiveData<String> {
        return  datos
    }
    fun setItem(item: String) {
        datos.value = item
    }
}