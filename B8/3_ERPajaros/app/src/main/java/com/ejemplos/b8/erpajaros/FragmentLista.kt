package com.ejemplos.b8.erpajaros

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentLista : Fragment() {
    var listenerLargo: View.OnLongClickListener? = null
    var recyclerView: RecyclerView? = null
    var valores: ArrayList<Datos>? = null
    var posicion:Int=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView: View = inflater.inflate(R.layout.fragment_recycler, container, false)
        recyclerView = rootView.findViewById(R.id.recycler)
        adapter = Adapter(MainActivity.datos!!)
        recyclerView?.adapter = adapter
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager =LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false)


        adapter!!.miOnClick { v ->
            val bundle = Bundle()
            bundle.putInt("POSICION", recyclerView!!.getChildAdapterPosition(v))
            val navController = NavHostFragment.findNavController(this)
            if (navController.currentDestination?.id == R.id.fragmentLista) {
                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) navController.navigate(
                    R.id.action_fragmentLista_to_fragmentDetalle,
                    bundle
                )
               else
                {
                    val fT = requireActivity().supportFragmentManager.beginTransaction()
                    fT.replace(R.id.detalle,FragmentDetalle::class.java,bundle).commit()
                }
            }

        }
        adapter!!.miOnLongClick { v ->
            val navController = NavHostFragment.findNavController(this)
            if (navController.currentDestination?.id == R.id.fragmentLista) {
                val bundle = Bundle()
                posicion=recyclerView!!.getChildLayoutPosition(v)
                bundle.putInt("POSICION",posicion)
                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                 navController.navigate(R.id.action_fragmentLista_to_dialogEliminar, bundle)
                else {
                    val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.lista) as NavHostFragment
                    val navControllerLista = navHostFragment.navController
                    navControllerLista.navigate(R.id.action_fragmentLista_to_dialogEliminar, bundle)
                }
            }
            true
        }

        return rootView
    }

     override fun onAttach(activity: Context) {
        super.onAttach(activity)
        try {
            valores = MainActivity.datos
            listenerLargo = activity as View.OnLongClickListener?
        } catch (e: ClassCastException) {
        }
    }

    companion object {
        var adapter: Adapter? = null
    }
}


