package com.ejemplos.b7.myapplication


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.agenda20_21.Contacto

class ItemViewModel : ViewModel() {
        private val liveData=MutableLiveData<Contacto>() //:MutableLiveData<String> by lazy { MutableLiveData<String>() }
        val getItem: LiveData<Contacto> get() = liveData

        fun setItem(item: Contacto) {
           liveData.value = item
        }
}