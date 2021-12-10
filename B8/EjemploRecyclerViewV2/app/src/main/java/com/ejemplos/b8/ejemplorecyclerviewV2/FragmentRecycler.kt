package com.ejemplos.b8.ejemplorecyclerviewV2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentRecycler: Fragment() {
    val model:UsuarioViewModel by activityViewModels()
    lateinit var tracker:SelectionTracker<Long>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_recycler,container,
            false)
        var recycler=view.findViewById<RecyclerView>(R.id.recyclerLista)
        recycler.setHasFixedSize(true)
        var adaptador=Adaptador(model.getListaDatos()!!)
        adaptador.setHasStableIds(true)
        recycler.adapter=adaptador

        tracker = SelectionTracker.Builder<Long>(
            "selecccion",
            recycler,
            StableIdKeyProvider(recycler),
            ElementoPulsadoId(recycler),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        if(savedInstanceState != null)
            tracker?.onRestoreInstanceState(savedInstanceState)

       adaptador.setTracker(tracker)

        tracker?.addObserver(
            object: SelectionTracker.SelectionObserver<Long>() {
                override fun onSelectionChanged() {
                    if (tracker!!.hasSelection()) {
                        var cadena=StringBuilder()
                        tracker?.selection?.forEach { id->
                            cadena.append(id.toString() +"\n") }
                        Toast.makeText(requireActivity(),cadena,
                            Toast.LENGTH_SHORT).show()
                    }
                }
            })

        recycler.layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,
            false)


        return view
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(outState != null)
            tracker?.onSaveInstanceState(outState)
    }
}