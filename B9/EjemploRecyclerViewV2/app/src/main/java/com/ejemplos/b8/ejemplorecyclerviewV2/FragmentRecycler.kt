package com.ejemplos.b8.ejemplorecyclerviewV2
import android.os.Bundle
import android.view.*
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
    lateinit var adaptador:Adaptador
    lateinit var recycler:RecyclerView
    var actionMode:ActionMode?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_recycler,container,
            false)
        recycler=view.findViewById<RecyclerView>(R.id.recyclerLista)
        recycler.setHasFixedSize(true)
        adaptador=Adaptador(model.getListaDatos()!!)
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
                        if (actionMode == null) {
                            actionMode = requireActivity().startActionMode(barraAccion)
                        }
                        actionMode?.title ="${tracker!!.selection.size()}"
                    }
                    else actionMode?.finish()

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

    var barraAccion=object:ActionMode.Callback{
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            requireActivity().menuInflater.inflate(R.menu.cab, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                   for(item in tracker.selection.sorted().reversed()) {
                       model.getListaDatos()?.removeAt(item.toInt())
                       adaptador.notifyItemChanged(item.toInt())
                   }
            tracker?.clearSelection()
            actionMode = null
            return true
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            tracker?.clearSelection()
            actionMode = null
        }

    }
}