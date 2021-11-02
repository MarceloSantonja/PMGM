package com.xusa.b3.ejemplo1fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.fragment.app.activityViewModels


class Fragment1:ListFragment(){

    val model:TransferirDatos by activityViewModels()
    lateinit var valores:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        valores =
            arrayOf("item1", "item2", "item3", "item4",
                "item5", "item6", "item7", "item8")

        val adaptador= ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1, valores)
        listAdapter=adaptador

    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        model.setItem(valores.get(position))
    }

}