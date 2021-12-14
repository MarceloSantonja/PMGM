package com.ejemplos.b10.ejemplocorrutinas1

import android.os.Bundle;
import android.util.Log
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Created by Director on 22/10/2014.
 */
class FragmentDos: Fragment() {
    var c:Job?=null
    lateinit  var texto:TextView
    lateinit  var tiempo:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,

        savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_dos,container,false)

        texto=view.findViewById(R.id.texto)
        tiempo=view.findViewById(R.id.tiempo)
        view.findViewById<Button>(R.id.runBlocking).setOnClickListener{ejemploRunBlocking()}
        view.findViewById<Button>(R.id.globalScope).setOnClickListener{ejemploGlobalScope()}
        view.findViewById<Button>(R.id.coroutineScope).setOnClickListener{ejemploCoroutineScopeWithMain()}
        view.findViewById<Button>(R.id.coroutineAsync).setOnClickListener{ejemploAsyncAway()}
        return view
    }
    fun ejemploRunBlocking()
    {
        val m:Long
        m=measureTimeMillis {runBlocking (Dispatchers.IO){
                //Lanzamos tres corrutinas con launch
                for (i in 1..3) {
                    //  launch(Dispatchers.Default) {
                        //delay es una funcion de suspensión por lo que al
                        //lanzar las tres corrutinas el tiempo no duran 5segundos
                        //ya que se hacen las tres intercaladas
                        //a diferencia de sleep
                        Log.d("CORRUTINA","${Thread.currentThread().name}")
                        delay(5000)
                       // Thread.sleep(5000)
                    //}
                }}
            }
        Toast.makeText(requireActivity(),"Ya han terminado las tareas lanzadas con el constructor runBlocking." +
                "\nSe desbloquea el hilo principal y se muestra este texto "+m,Toast.LENGTH_LONG).show()
    }

    private fun ejemploGlobalScope() {
           GlobalScope.launch(Dispatchers.Main) {
               while(isActive) {
                       delay(3000)
                       Toast.makeText(requireActivity(), "GlobalScope", Toast.LENGTH_SHORT).show()
               }
        }
    }
    private fun ejemploAsyncAway()
    {
        var cadena:String?=null
        CoroutineScope(Dispatchers.Main).launch {
            val job = async {
                for (i in 1..5) {
                    tiempo.text = i.toString()
                    withContext(Dispatchers.IO) { delay(1000) }
                }
                "Ha terminado la corrutina async"
            }
           cadena = job.await()
            Toast.makeText(requireActivity(),cadena, Toast.LENGTH_SHORT).show()
        }
    }

    var coroutineScope= CoroutineScope(Dispatchers.Main)
    private fun ejemploCoroutineScopeWithMain()
    {
            coroutineScope?.launch {
            while (isActive) {
                delay(3000)
                Toast.makeText(requireActivity(), "[CoroutineScope-Main] I'm alive on ${Thread.currentThread().name}!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        coroutineScope?.cancel()
    }
}
