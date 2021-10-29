package com.marcelo.ejemplo1fragments

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

class Fragment1 : ListFragment() {
// no necesita el fragment1.xml
    val model:transferirDatos by activityViewModels()
    lateinit var valores: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

          valores =
            arrayOf<String>("item1", "item2", "item3", "item4",
                "item5", "item6", "item7", "item8")
        val adaptador = ArrayAdapter<String>(requireActivity(),android.R.layout
            .simple_list_item_1, valores )
        listAdapter =adaptador


    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        model.setItem(valores.get(position))
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        super.onCreateView(inflater, container, savedInstanceState)
//
////        vista.findViewById<Button>(R.id.boton).setOnClickListener {
////        model.setItem(vista.findViewById<EditText>(R.id.editText).text.toString())
////
////        }
//
//
//        return vista
//    }
}