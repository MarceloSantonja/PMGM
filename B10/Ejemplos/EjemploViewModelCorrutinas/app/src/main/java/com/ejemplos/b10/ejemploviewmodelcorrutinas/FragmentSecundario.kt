package com.ejemplos.b10.ejemploviewmodelcorrutinas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*


class FragmentSecundario:Fragment() {
    private val model:ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_secundario, container, false)
      //  val progresBar=view.findViewById<ProgressBar>(R.id.progressBar)
        //progresBar.visibility=View.INVISIBLE
        view.findViewById<Button>(R.id.descargr).setOnClickListener {

            val progresBar=view.findViewById<ProgressBar>(R.id.progressBar)
            progresBar.visibility=View.VISIBLE
            model.descargarDatos()
            //No sale otra vez la barra de progreso porque el observer detecta el cambio al añadir
            // o borrar elementos y por eso pasa directamente a cargar el fragment
            val manejador = Observer<ArrayList<String>>{listaCadenas ->
               viewLifecycleOwner.lifecycleScope.launch {
                    withContext(Dispatchers.Main){
                        val fM: FragmentManager = requireActivity().supportFragmentManager
                        val fT: FragmentTransaction = fM.beginTransaction()
                        fT.replace(R.id.fragment_uno, MyListFragment(listaCadenas))
                        fT.addToBackStack(null)
                        progresBar.visibility=View.INVISIBLE
                        fT.commit()}
                }}
                /*Se podría hacer también asi
                CoroutineScope(Dispatchers.Main).launch {
                    val fM: FragmentManager = requireActivity().supportFragmentManager
                    val fT: FragmentTransaction = fM.beginTransaction()
                    fT.replace(R.id.fragment_uno, MyListFragment(listaCadenas))
                    fT.addToBackStack(null)
                    progresBar.visibility=View.INVISIBLE
                    fT.commit()}
                }*/


            //viewLifecycleOwner esta vinculado a la parte del ciclo de vida del fragmentoque que ocurre mientras existe interfaz con
            // el usuario es decir desde en onCreteView al onDestroyView
            //this está vinculado al ciclo de vida general del fragmento ( onCreate(), onDestroy()), como el observer esta dentro del
            //onCreateView no nos deja poner this
            model.datos.observe(viewLifecycleOwner,manejador)

        }
        return view
    }
}