package com.xusa.b3.fragmentnavigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapatadorPaginacion (context: AppCompatActivity):
FragmentStateAdapter(context) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> Fragment1()
        }
    }

    /*  override fun getItemCount()=3
      override fun createFragment(position: Int): Fragment {
          return when (position) {
              0 -> MyListFragment()
              1 -> FragmentSecundario()
              2 -> FragmentTercero()
              else -> MyListFragment()
          }
      }*/

}