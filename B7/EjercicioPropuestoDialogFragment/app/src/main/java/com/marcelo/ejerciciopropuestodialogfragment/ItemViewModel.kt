package com.marcelo.ejerciciopropuestodialogfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private val liveData= MutableLiveData<Usuario>()
    val getItem: LiveData<Usuario> get() = liveData
    fun setItem(item: Usuario) {
        liveData.value = item
    }
}