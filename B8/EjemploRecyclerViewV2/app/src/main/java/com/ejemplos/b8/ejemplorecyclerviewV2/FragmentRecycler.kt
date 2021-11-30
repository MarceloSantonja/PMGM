package com.ejemplos.b8.ejemplorecyclerviewV2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    val model:ViewModelUsuario by activityViewModels()
    lateinit var tracker: SelectionTracker<Long>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_recycler,container,false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerList)
        recyclerView.setHasFixedSize(true)
        val adaptador = Adaptador(MainActivity.anadirDatos(),requireActivity())

        adaptador.setHasStableIds(true)
        recyclerView.adapter = adaptador
        tracker = SelectionTracker.Builder(
            "selecccion",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            CapturaVista(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()
        if(savedInstanceState != null)
            tracker?.onRestoreInstanceState(savedInstanceState)
        recyclerView.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        adaptador.setTracker(tracker)


        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(outState != null)
            tracker?.onSaveInstanceState(outState)
    }
}