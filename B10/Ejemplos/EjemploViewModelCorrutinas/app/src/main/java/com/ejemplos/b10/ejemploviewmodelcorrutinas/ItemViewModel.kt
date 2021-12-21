package com.ejemplos.b10.ejemploviewmodelcorrutinas


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList

class ItemViewModel : ViewModel() {
    private val valores =
        arrayOf("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8")
    private var liveData =
        MutableLiveData<ArrayList<String>>() //:MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val datos: LiveData<ArrayList<String>> get() = liveData

    fun descargarDatos() {
        val random = Random()
        var aux = ArrayList<String>()
        //Simulación de una descarga lenta de datos
        val numeroElementos = random.nextInt(10)
        viewModelScope.launch {
            for (i in 0..numeroElementos) {
                aux.add(valores[random.nextInt(valores.size - 1)])
                delay(1000)
            }
            liveData.value = aux
        }
    }
}