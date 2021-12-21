package com.ejemplos.b10.ejemploviewmodelcorrutinas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MyListFragment(var listaCadenas:ArrayList<String>): ListFragment() {
    private val model:ItemViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            listAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, listaCadenas)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        model.datos.value?.removeAt(position)
       listAdapter=ArrayAdapter(requireActivity(),android.R.layout.simple_expandable_list_item_1,model.datos.value!!)

    }
}

