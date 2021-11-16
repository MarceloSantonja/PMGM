package com.ejemplos.b8.erpajaros

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class DialogEliminar : DialogFragment() {
    override  fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(getActivity())
        if (arguments != null) {
            val posicion = arguments?.getInt("POSICION")
            builder.setMessage("Deseas Eliminar el item?")
                .setTitle("AVISO")
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id ->
                    MainActivity.datos?.removeAt(posicion!!)
                    FragmentLista.adapter!!.notifyItemRemoved(posicion!!)
                })
        }
        return builder.create()
    }
}
