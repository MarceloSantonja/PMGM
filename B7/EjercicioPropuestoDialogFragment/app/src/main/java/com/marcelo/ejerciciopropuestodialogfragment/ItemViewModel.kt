package com.marcelo.ejerciciopropuestodialogfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// es como una variable global con vida, puedes cambiar la variable con el set o el get, sirve
// sirve para que las diferentes fragments y actividades puedan acceder al contenido
class ItemViewModel : ViewModel() {
    private val liveData= MutableLiveData<Usuario>()
    val getItem: LiveData<Usuario> get() = liveData
    fun setItem(item: Usuario) {
        liveData.value = item
    }






}