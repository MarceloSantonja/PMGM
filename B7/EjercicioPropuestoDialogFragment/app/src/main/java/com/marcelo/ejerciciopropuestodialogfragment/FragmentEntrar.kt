package com.marcelo.ejerciciopropuestodialogfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentEntrar : Fragment() {

    companion object {
        fun newInstance() = FragmentEntrar()
    }

    private lateinit var viewModel: TransferirDatos

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entrar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TransferirDatos::class.java)
        // TODO: Use the ViewModel
    }

}