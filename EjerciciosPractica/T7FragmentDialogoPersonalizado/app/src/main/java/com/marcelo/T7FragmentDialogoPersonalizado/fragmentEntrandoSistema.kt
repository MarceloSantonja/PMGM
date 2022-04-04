package com.marcelo.T7FragmentDialogoPersonalizado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import T7FragmentDialogoPersonalizado.R

class fragmentEntrandoSistema : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entrado_sistema, container, false)
    }

}